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
package net.lsafer.oidc.client

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import net.lsafer.oidc.client.internal.asInstantFromEpochSeconds
import net.lsafer.oidc.client.internal.asStringOrNull
import net.lsafer.oidc.oauth.OAuth
import net.lsafer.oidc.openid.OpenID
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
@Suppress("PropertyName")
value class RegistrationObject(val value: JsonObject) {
    private fun string(name: String) = value[name]?.asStringOrNull
    private fun instantEpochSeconds(name: String) = value[name]?.asInstantFromEpochSeconds

    val client_id get() = string(OAuth.Param.CLIENT_ID)
    val client_secret get() = string(OAuth.Param.CLIENT_SECRET)
    val registration_access_token get() = string(OpenID.Param.REGISTRATION_ACCESS_TOKEN)
    val registration_client_uri get() = string(OpenID.Param.REGISTRATION_CLIENT_URI)
    val client_id_issued_at get() = instantEpochSeconds(OpenID.Param.CLIENT_ID_ISSUED_AT)
    val client_secret_expires_at get() = instantEpochSeconds(OpenID.Param.CLIENT_SECRET_EXPIRES_AT)
}
