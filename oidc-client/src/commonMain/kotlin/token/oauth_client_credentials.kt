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
import net.lsafer.oidc.client.CredentialsObject
import net.lsafer.oidc.client.DiscoveryObject
import net.lsafer.oidc.client.OidcClient
import net.lsafer.oidc.client.RegistrationObject
import net.lsafer.oidc.oauth.OAuth
import net.lsafer.oidc.serial.OidcScope

// https://datatracker.ietf.org/doc/html/rfc6749#section-4.4

/**
 * [OAuth - Section 4.4](https://datatracker.ietf.org/doc/html/rfc6749#section-4.4)
 *
 * @param discovery OP configuration.
 * @param registration client registration object returned from OP.
 * @param scope access scope.
 */
suspend fun OidcClient.clientCredentialsGrant(
    discovery: DiscoveryObject,
    registration: RegistrationObject,
    scope: Set<OidcScope>,
): CredentialsObject {
    val endpoint = requireNotNull(discovery.token_endpoint) { "discovery.token_endpoint" }
    val clientId = requireNotNull(registration.client_id) { "registration.client_id" }
    val clientSecret = requireNotNull(registration.client_secret) { "registration.client_secret" }

    val input = parameters {
        this[OAuth.Param.GRANT_TYPE] = OAuth.GrantType.CLIENT_CREDENTIALS
        this[OAuth.Param.SCOPE] = scope.joinToString(" ")
    }

    val response = httpClient.submitForm(endpoint, input) {
        basicAuth(clientId, clientSecret)
    }

    return CredentialsObject(response.body<JsonObject>())
}
