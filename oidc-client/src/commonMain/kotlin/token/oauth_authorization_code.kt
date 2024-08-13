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
package net.lsafer.oidc.client.token

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import kotlinx.serialization.json.JsonObject
import net.lsafer.oidc.client.*
import net.lsafer.oidc.oauth.OAuth

/**
 * [OAuth - Section 4.1.3](https://datatracker.ietf.org/doc/html/rfc6749#section-4.1.3)
 *
 * @param discovery OP configuration.
 * @param registration client registration object returned from OP.
 * @param authorizationRequest authorization request parameters.
 * @param authorizationResponse authorization response parameters.
 */
suspend fun OidcClient.authorizationCodeGrant(
    discovery: DiscoveryObject,
    registration: RegistrationObject,
    authorizationRequest: AuthorizationRequest,
    authorizationResponse: AuthorizationResponse,
): CredentialsObject {
    val endpoint = requireNotNull(discovery.token_endpoint) { "discovery.token_endpoint" }
    val clientId = requireNotNull(registration.client_id) { "registration.client_id" }
    val clientSecret = requireNotNull(registration.client_secret) { "registration.client_secret" }
    val code = requireNotNull(authorizationResponse.code) { "authorizationResponse.code" }

    val input = parameters {
        this[OAuth.Param.GRANT_TYPE] = OAuth.GrantType.AUTHORIZATION_CODE
        this[OAuth.Param.CODE] = code
        this[OAuth.Param.REDIRECT_URI] = authorizationRequest.redirectUri
        this[OAuth.Param.CLIENT_ID] = clientId

        authorizationRequest.codeVerifier?.let { this[OAuth.Param.CODE_VERIFIER] = it }
    }

    val response = httpClient.submitForm(endpoint, input) {
        basicAuth(clientId, clientSecret)
    }

    return CredentialsObject(response.body<JsonObject>())
}
