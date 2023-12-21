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
import net.lsafer.oidc.openid.OpenID

/**
 * @see OAuth.ResponseType
 * @see OpenID.ResponseType
 */
@Serializable
enum class ResponseType(val value: String) {
    /** @see OAuth.ResponseType.CODE */
    @SerialName(OAuth.ResponseType.CODE)
    CODE(OAuth.ResponseType.CODE),

    /** @see OAuth.ResponseType.TOKEN */
    @SerialName(OAuth.ResponseType.TOKEN)
    TOKEN(OAuth.ResponseType.TOKEN),

    /** @see OpenID.ResponseType.NONE */
    @SerialName(OpenID.ResponseType.NONE)
    NONE(OpenID.ResponseType.NONE),

    /** @see OpenID.ResponseType.ID_TOKEN */
    @SerialName(OpenID.ResponseType.ID_TOKEN)
    ID_TOKEN(OpenID.ResponseType.ID_TOKEN);

    override fun toString() = value
}

/**
 * @see OAuth.ResponseType
 * @see OpenID.ResponseType
 */
object ResponseTypeSet {
    /** @see OAuth.ResponseType.CODE */
    val CODE = setOf(ResponseType.CODE)

    /** @see OAuth.ResponseType.TOKEN */
    val TOKEN = setOf(ResponseType.TOKEN)

    /** @see OpenID.ResponseType.NONE */
    val NONE = setOf(ResponseType.NONE)

    /** @see OpenID.ResponseType.ID_TOKEN */
    val ID_TOKEN = setOf(ResponseType.ID_TOKEN)

    /** @see OpenID.ResponseType.ID_TOKEN_TOKEN */
    val ID_TOKEN_TOKEN = setOf(ResponseType.ID_TOKEN, ResponseType.TOKEN)

    /** @see OpenID.ResponseType.CODE_TOKEN */
    val CODE_TOKEN = setOf(ResponseType.CODE, ResponseType.TOKEN)

    /** @see OpenID.ResponseType.CODE_ID_TOKEN */
    val CODE_ID_TOKEN = setOf(ResponseType.CODE, ResponseType.ID_TOKEN)

    /** @see OpenID.ResponseType.CODE_ID_TOKEN_TOKEN */
    val CODE_ID_TOKEN_TOKEN = setOf(ResponseType.CODE, ResponseType.ID_TOKEN, ResponseType.TOKEN)
}

fun String.toResponseTypeSetOrNull(): Set<ResponseType>? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        OAuth.ResponseType.CODE,
        -> ResponseTypeSet.CODE

        OAuth.ResponseType.TOKEN,
        -> ResponseTypeSet.TOKEN

        OpenID.ResponseType.NONE,
        -> ResponseTypeSet.NONE

        OpenID.ResponseType.ID_TOKEN,
        -> ResponseTypeSet.ID_TOKEN

        OpenID.ResponseType.ID_TOKEN_TOKEN,
        "token id_token",
        -> ResponseTypeSet.ID_TOKEN_TOKEN

        OpenID.ResponseType.CODE_TOKEN,
        "token code",
        -> ResponseTypeSet.CODE_TOKEN

        OpenID.ResponseType.CODE_ID_TOKEN,
        "id_token code",
        -> ResponseTypeSet.CODE_ID_TOKEN

        OpenID.ResponseType.CODE_ID_TOKEN_TOKEN,
        "code token id_token",
        "id_token code token",
        "id_token token code",
        "token code id_token",
        "token id_token code",
        -> ResponseTypeSet.CODE_ID_TOKEN_TOKEN

        else -> null
    }
}
