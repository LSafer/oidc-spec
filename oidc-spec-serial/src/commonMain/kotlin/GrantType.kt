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
import net.lsafer.oidc.oauth.OAuth

/** @see OAuth.GrantType */
@Serializable
enum class GrantType(val value: String) {
    /** @see OAuth.GrantType.AUTHORIZATION_CODE */
    @SerialName(OAuth.GrantType.AUTHORIZATION_CODE)
    AUTHORIZATION_CODE(OAuth.GrantType.AUTHORIZATION_CODE),

    /** @see OAuth.GrantType.IMPLICIT */
    @SerialName(OAuth.GrantType.IMPLICIT)
    IMPLICIT(OAuth.GrantType.IMPLICIT),

    /** @see OAuth.GrantType.CLIENT_CREDENTIALS */
    @SerialName(OAuth.GrantType.CLIENT_CREDENTIALS)
    CLIENT_CREDENTIALS(OAuth.GrantType.CLIENT_CREDENTIALS),

    /** @see OAuth.GrantType.REFRESH_TOKEN */
    @SerialName(OAuth.GrantType.REFRESH_TOKEN)
    REFRESH_TOKEN(OAuth.GrantType.REFRESH_TOKEN),

    /** @see OAuth.GrantType.PASSWORD */
    @SerialName(OAuth.GrantType.PASSWORD)
    PASSWORD(OAuth.GrantType.PASSWORD),

    /** @see OAuth.GrantType.TOKEN_EXCHANGE */
    @SerialName(OAuth.GrantType.TOKEN_EXCHANGE)
    TOKEN_EXCHANGE(OAuth.GrantType.TOKEN_EXCHANGE);

    override fun toString() = value
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
    }
}

fun String.toGrantTypeOrNull(): GrantType? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        OAuth.GrantType.AUTHORIZATION_CODE,
        -> GrantType.AUTHORIZATION_CODE

        OAuth.GrantType.IMPLICIT,
        -> GrantType.IMPLICIT

        OAuth.GrantType.CLIENT_CREDENTIALS,
        -> GrantType.CLIENT_CREDENTIALS

        OAuth.GrantType.REFRESH_TOKEN,
        -> GrantType.REFRESH_TOKEN

        OAuth.GrantType.PASSWORD,
        -> GrantType.PASSWORD

        OAuth.GrantType.TOKEN_EXCHANGE,
        -> GrantType.TOKEN_EXCHANGE

        else -> null
    }
}
