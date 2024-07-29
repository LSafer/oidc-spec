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
package net.lsafer.oidc.client.userinfo

import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.json.JsonObject
import net.lsafer.oidc.client.CredentialsObject
import net.lsafer.oidc.client.DiscoveryObject
import net.lsafer.oidc.client.OidcClient
import net.lsafer.oidc.client.UserinfoObject

// https://openid.net/specs/openid-connect-core-1_0.html#UserInfo

/**
 * [OpenID.Core - Section 5.3](https://openid.net/specs/openid-connect-core-1_0.html#UserInfo)
 *
 * @param discovery OP configuration.
 * @param credentials client+subject credentials
 */
suspend fun OidcClient.fetchUserinfo(
    discovery: DiscoveryObject,
    credentials: CredentialsObject,
): UserinfoObject {
    val endpoint = requireNotNull(discovery.userinfo_endpoint) { "discovery.userinfo_endpoint" }
    val token = requireNotNull(credentials.access_token) { "credentials.access_token" }

    val response = httpClient.get(endpoint) {
        bearerAuth(token)
    }

    return UserinfoObject(response.body<JsonObject>())
}
