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
import net.lsafer.oidc.oauth.OAuth
import kotlin.jvm.JvmInline

/** @see OAuth.GrantType */
@JvmInline
@Serializable
value class GrantType(val value: String) {
    companion object {
        /** @see OAuth.GrantType.AUTHORIZATION_CODE */
        val AUTHORIZATION_CODE = GrantType(OAuth.GrantType.AUTHORIZATION_CODE)

        /** @see OAuth.GrantType.IMPLICIT */
        val IMPLICIT = GrantType(OAuth.GrantType.IMPLICIT)

        /** @see OAuth.GrantType.CLIENT_CREDENTIALS */
        val CLIENT_CREDENTIALS = GrantType(OAuth.GrantType.CLIENT_CREDENTIALS)

        /** @see OAuth.GrantType.REFRESH_TOKEN */
        val REFRESH_TOKEN = GrantType(OAuth.GrantType.REFRESH_TOKEN)

        /** @see OAuth.GrantType.PASSWORD */
        val PASSWORD = GrantType(OAuth.GrantType.PASSWORD)

        /** @see OAuth.GrantType.TOKEN_EXCHANGE */
        val TOKEN_EXCHANGE = GrantType(OAuth.GrantType.TOKEN_EXCHANGE)
    }

    override fun toString() = value
}

fun String.asGrantType(): GrantType {
    return GrantType(this)
}

fun ResponseType.associatedGrantTypeOrNull(): GrantType? {
    return when (this) {
        ResponseType.NONE,
            -> null

        ResponseType.CODE,
            -> GrantType.AUTHORIZATION_CODE

        ResponseType.ID_TOKEN,
        ResponseType.TOKEN,
            -> GrantType.IMPLICIT

        else -> null
    }
}
