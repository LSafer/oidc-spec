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
package net.lsafer.oidc.client.discovery

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.JsonObject
import net.lsafer.oidc.client.DiscoveryObject
import net.lsafer.oidc.client.OidcClient
import net.lsafer.oidc.openid.OpenID

// https://openid.net/specs/openid-connect-discovery-1_0.html

/**
 * [OpenID.Discovery - Section 4](https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderConfig)
 */
suspend fun OidcClient.fetchConfiguration(issuer: String): DiscoveryObject {
    val response = httpClient.get(issuer) {
        url.appendPathSegments(OpenID.Endpoint.OPENID_CONFIGURATION, encodeSlash = true)
    }

    return DiscoveryObject(response.body<JsonObject>())
}
