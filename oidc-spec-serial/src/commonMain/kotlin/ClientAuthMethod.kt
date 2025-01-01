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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.lsafer.oidc.openid.OpenID

/** @see OpenID.ClientAuthMethod */
@Serializable
enum class ClientAuthMethod(val value: String) {
    /** @see OpenID.ClientAuthMethod.CLIENT_SECRET_BASIC */
    @SerialName(OpenID.ClientAuthMethod.CLIENT_SECRET_BASIC)
    CLIENT_SECRET_BASIC(OpenID.ClientAuthMethod.CLIENT_SECRET_BASIC),

    /** @see OpenID.ClientAuthMethod.CLIENT_SECRET_POST */
    @SerialName(OpenID.ClientAuthMethod.CLIENT_SECRET_POST)
    CLIENT_SECRET_POST(OpenID.ClientAuthMethod.CLIENT_SECRET_POST),

    /** @see OpenID.ClientAuthMethod.CLIENT_SECRET_JWT */
    @SerialName(OpenID.ClientAuthMethod.CLIENT_SECRET_JWT)
    CLIENT_SECRET_JWT(OpenID.ClientAuthMethod.CLIENT_SECRET_JWT),

    /** @see OpenID.ClientAuthMethod.PRIVATE_KEY_JWT */
    @SerialName(OpenID.ClientAuthMethod.PRIVATE_KEY_JWT)
    PRIVATE_KEY_JWT(OpenID.ClientAuthMethod.PRIVATE_KEY_JWT),

    /** @see OpenID.ClientAuthMethod.NONE */
    @SerialName(OpenID.ClientAuthMethod.NONE)
    NONE(OpenID.ClientAuthMethod.NONE);

    override fun toString() = value
}

fun String.toClientAuthMethodOrNull(): ClientAuthMethod? {
    return when (this) {
        OpenID.ClientAuthMethod.CLIENT_SECRET_BASIC,
        -> ClientAuthMethod.CLIENT_SECRET_BASIC

        OpenID.ClientAuthMethod.CLIENT_SECRET_POST,
        -> ClientAuthMethod.CLIENT_SECRET_POST

        OpenID.ClientAuthMethod.CLIENT_SECRET_JWT,
        -> ClientAuthMethod.CLIENT_SECRET_JWT

        OpenID.ClientAuthMethod.PRIVATE_KEY_JWT,
        -> ClientAuthMethod.PRIVATE_KEY_JWT

        OpenID.ClientAuthMethod.NONE,
        -> ClientAuthMethod.NONE

        else -> null
    }
}
