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
package net.lsafer.oidc.serial

import kotlinx.serialization.Serializable
import net.lsafer.oidc.openid.OpenID
import kotlin.jvm.JvmInline

/** @see OpenID.ClientAuthMethod */
@JvmInline
@Serializable
value class ClientAuthMethod(val value: String) {
    companion object {
        /** @see OpenID.ClientAuthMethod.CLIENT_SECRET_BASIC */
        val CLIENT_SECRET_BASIC = ClientAuthMethod(OpenID.ClientAuthMethod.CLIENT_SECRET_BASIC)

        /** @see OpenID.ClientAuthMethod.CLIENT_SECRET_POST */
        val CLIENT_SECRET_POST = ClientAuthMethod(OpenID.ClientAuthMethod.CLIENT_SECRET_POST)

        /** @see OpenID.ClientAuthMethod.CLIENT_SECRET_JWT */
        val CLIENT_SECRET_JWT = ClientAuthMethod(OpenID.ClientAuthMethod.CLIENT_SECRET_JWT)

        /** @see OpenID.ClientAuthMethod.PRIVATE_KEY_JWT */
        val PRIVATE_KEY_JWT = ClientAuthMethod(OpenID.ClientAuthMethod.PRIVATE_KEY_JWT)

        /** @see OpenID.ClientAuthMethod.NONE */
        val NONE = ClientAuthMethod(OpenID.ClientAuthMethod.NONE)
    }

    override fun toString() = value
}

fun String.asClientAuthMethod(): ClientAuthMethod {
    return ClientAuthMethod(this)
}
