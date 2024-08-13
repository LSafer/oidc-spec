/*
 *	Copyright 2023 cufy.org and meemer.com
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package net.lsafer.oidc.client.authorization

import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import net.lsafer.oidc.client.AuthorizationRequest
import net.lsafer.oidc.client.DiscoveryObject
import net.lsafer.oidc.oauth.OAuth
import net.lsafer.oidc.openid.OpenID
import net.lsafer.oidc.serial.*
import org.kotlincrypto.hash.sha2.SHA256
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi
import kotlin.time.Duration

/**
 * [OAuth - Section 4.1.1](https://datatracker.ietf.org/doc/html/rfc6749#section-4.1.1)
 *
 * @param discovery OP configuration.
 * @param authorizationRequest authorization request parameters.
 * @param clientId the client id.
 * @param responseType the response type
 */
fun authorizationRequestUrl(
    discovery: DiscoveryObject,
    authorizationRequest: AuthorizationRequest,
    //
    clientId: String,
    responseType: Set<ResponseType> = ResponseTypeSet.CODE,
    //
    codeChallengeMethod: CodeChallengeMethod = CodeChallengeMethod.S256,
    //
    responseMode: ResponseMode? = null,
    nonce: String? = null,
    display: OidcDisplay? = null,
    prompt: Set<OidcPrompt>? = null,
    maxAge: Duration? = null,
    uiLocales: List<String>? = null,
    idTokenHint: String? = null,
    loginHint: String? = null,
    acrValues: List<OidcACR>? = null,
    //
    request: String? = null,
    requestUri: String? = null,
    //
    claimsLocales: List<String>? = null,
    //
    claims: ClaimsObject? = null,
): Url {
    val endpoint = requireNotNull(discovery.authorization_endpoint) { "discovery.authorization_endpoint" }

    val builder = URLBuilder()
    builder.takeFrom(endpoint)

    // https://datatracker.ietf.org/doc/html/rfc6749#section-4.1.1
    builder.parameters[OAuth.Param.CLIENT_ID] = clientId
    builder.parameters[OAuth.Param.RESPONSE_TYPE] = responseType.joinToString(" ")
    builder.parameters[OAuth.Param.REDIRECT_URI] = authorizationRequest.redirectUri
    builder.parameters[OAuth.Param.SCOPE] = authorizationRequest.scope.joinToString(" ")

    authorizationRequest.state?.let { builder.parameters[OAuth.Param.STATE] = it }

    // https://datatracker.ietf.org/doc/html/rfc7636
    if (authorizationRequest.codeVerifier != null) when (codeChallengeMethod) {
        CodeChallengeMethod.PLAIN -> {
            // code_challenge = code_verifier
            builder.parameters[OAuth.Param.CODE_CHALLENGE] = authorizationRequest.codeVerifier
            builder.parameters[OAuth.Param.CODE_CHALLENGE_METHOD] = codeChallengeMethod.value
        }

        CodeChallengeMethod.S256 -> {
            // code_challenge = BASE64URL-ENCODE(SHA256(ASCII(code_verifier)))
            val codeVerifierBytes = authorizationRequest.codeVerifier.encodeToByteArray()

            @OptIn(ExperimentalEncodingApi::class)
            val base64url = Base64.UrlSafe.encode(SHA256().digest(codeVerifierBytes))

            builder.parameters[OAuth.Param.CODE_CHALLENGE] = base64url
            builder.parameters[OAuth.Param.CODE_CHALLENGE_METHOD] = codeChallengeMethod.value
        }
    }

    // https://openid.net/specs/openid-connect-core-1_0.html#AuthRequest
    responseMode?.let { builder.parameters[OpenID.Param.RESPONSE_MODE] = it.value }
    nonce?.let { builder.parameters[OpenID.Param.NONCE] = it }
    display?.let { builder.parameters[OpenID.Param.DISPLAY] = it.value }
    prompt?.let { builder.parameters[OpenID.Param.PROMPT] = prompt.joinToString(" ") }
    maxAge?.let { builder.parameters[OpenID.Param.MAX_AGE] = it.inWholeSeconds.toString() }
    uiLocales?.let { builder.parameters[OpenID.Param.UI_LOCALES] = it.joinToString(" ") }
    idTokenHint?.let { builder.parameters[OpenID.Param.ID_TOKEN_HINT] = it }
    loginHint?.let { builder.parameters[OpenID.Param.LOGIN_HINT] = it }
    acrValues?.let { builder.parameters[OpenID.Param.ACR_VALUES] = it.joinToString(" ") }

    // https://openid.net/specs/openid-connect-core-1_0.html#JWTRequests
    request?.let { builder.parameters[OpenID.Param.REQUEST] = it }
    requestUri?.let { builder.parameters[OpenID.Param.REQUEST_URI] = it }

    // https://openid.net/specs/openid-connect-core-1_0.html#ClaimsLanguagesAndScripts
    claimsLocales?.let { builder.parameters[OpenID.Param.CLAIMS_LOCALES] = it.joinToString(" ") }

    // https://openid.net/specs/openid-connect-core-1_0.html#ClaimsParameter
    claims?.let { builder.parameters[OpenID.Param.CLAIMS] = Json.encodeToString(claims) }

    return builder.build()
}
