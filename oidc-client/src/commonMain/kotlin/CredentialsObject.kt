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

import kotlinx.serialization.json.JsonObject
import net.lsafer.oidc.client.internal.asDurationFromSeconds
import net.lsafer.oidc.client.internal.asStringOrNull
import net.lsafer.oidc.oauth.OAuth
import kotlin.jvm.JvmInline

@JvmInline
@Suppress("PropertyName")
value class CredentialsObject(val value: JsonObject) {
    private fun string(name: String) = value[name]?.asStringOrNull
    private fun int64(name: String) = value[name]?.asDurationFromSeconds

    val access_token get() = string(OAuth.Param.ACCESS_TOKEN)
    val token_type get() = string(OAuth.Param.TOKEN_TYPE)
    val expires_in get() = int64(OAuth.Param.EXPIRES_IN)
}
