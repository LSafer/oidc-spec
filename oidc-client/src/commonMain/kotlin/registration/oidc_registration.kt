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
package net.lsafer.oidc.client.registration

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.JsonObject
import net.lsafer.oidc.client.DiscoveryObject
import net.lsafer.oidc.client.OidcClient
import net.lsafer.oidc.client.RegistrationObject

// https://openid.net/specs/openid-connect-registration-1_0.html

/**
 * [OpenID.Registration - Section 3](https://openid.net/specs/openid-connect-registration-1_0.html#ClientRegistration)
 *
 * @param discovery OP configuration.
 * @param metadata new client metadata. (check the response for overrides)
 * @param token initial access token. (optional, depending on OP)
 */
suspend fun OidcClient.createClient(
    discovery: DiscoveryObject,
    metadata: JsonObject,
    token: String? = null,
): RegistrationObject {
    val endpoint = requireNotNull(discovery.registration_endpoint) {
        "discovery.registration_endpoint"
    }

    val response = httpClient.post(endpoint) {
        if (token != null) bearerAuth(token)
        contentType(ContentType.Application.Json)
        setBody(metadata)
    }

    return RegistrationObject(response.body<JsonObject>())
}

/**
 * [OpenID.Registration - Section 4](https://openid.net/specs/openid-connect-registration-1_0.html#ClientConfigurationEndpoint)
 *
 * @param registration client registration object returned from OP.
 */
suspend fun OidcClient.getClient(
    registration: RegistrationObject,
): RegistrationObject {
    val endpoint = requireNotNull(registration.registration_client_uri) {
        "registration.registration_client_uri"
    }
    val token = requireNotNull(registration.registration_access_token) {
        "registration.registration_access_token"
    }

    val response = httpClient.get(endpoint) {
        bearerAuth(token)
    }

    return RegistrationObject(response.body<JsonObject>())
}

/**
 * [OpenID.Registration - Section 4](https://openid.net/specs/openid-connect-registration-1_0.html#ClientConfigurationEndpoint)
 *
 * @param registration client registration object returned from OP.
 */
suspend fun OidcClient.deleteClient(
    registration: RegistrationObject,
) {
    val endpoint = requireNotNull(registration.registration_client_uri) {
        "registration.registration_client_uri"
    }
    val token = requireNotNull(registration.registration_access_token) {
        "registration.registration_access_token"
    }

    httpClient.delete(endpoint) {
        bearerAuth(token)
    }
}
