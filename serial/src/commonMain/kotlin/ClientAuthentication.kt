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

/** @see OpenID.ClientAuthentication */
@Serializable
enum class ClientAuthentication(val value: String) {
    /** @see OpenID.ClientAuthentication.CLIENT_SECRET_BASIC */
    @SerialName(OpenID.ClientAuthentication.CLIENT_SECRET_BASIC)
    CLIENT_SECRET_BASIC(OpenID.ClientAuthentication.CLIENT_SECRET_BASIC),

    /** @see OpenID.ClientAuthentication.CLIENT_SECRET_POST */
    @SerialName(OpenID.ClientAuthentication.CLIENT_SECRET_POST)
    CLIENT_SECRET_POST(OpenID.ClientAuthentication.CLIENT_SECRET_POST),

    /** @see OpenID.ClientAuthentication.CLIENT_SECRET_JWT */
    @SerialName(OpenID.ClientAuthentication.CLIENT_SECRET_JWT)
    CLIENT_SECRET_JWT(OpenID.ClientAuthentication.CLIENT_SECRET_JWT),

    /** @see OpenID.ClientAuthentication.PRIVATE_KEY_JWT */
    @SerialName(OpenID.ClientAuthentication.PRIVATE_KEY_JWT)
    PRIVATE_KEY_JWT(OpenID.ClientAuthentication.PRIVATE_KEY_JWT),

    /** @see OpenID.ClientAuthentication.NONE */
    @SerialName(OpenID.ClientAuthentication.NONE)
    NONE(OpenID.ClientAuthentication.NONE);

    override fun toString() = value
}

fun String.toClientAuthenticationOrNull(): ClientAuthentication? {
    return when (this) {
        OpenID.ClientAuthentication.CLIENT_SECRET_BASIC,
        -> ClientAuthentication.CLIENT_SECRET_BASIC

        OpenID.ClientAuthentication.CLIENT_SECRET_POST,
        -> ClientAuthentication.CLIENT_SECRET_POST

        OpenID.ClientAuthentication.CLIENT_SECRET_JWT,
        -> ClientAuthentication.CLIENT_SECRET_JWT

        OpenID.ClientAuthentication.PRIVATE_KEY_JWT,
        -> ClientAuthentication.PRIVATE_KEY_JWT

        OpenID.ClientAuthentication.NONE,
        -> ClientAuthentication.NONE

        else -> null
    }
}
