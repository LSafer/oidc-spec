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

/** @see OpenID.ResponseMode */
@Serializable
enum class ResponseMode(val value: String) {
    /** @see OpenID.ResponseMode.QUERY */
    @SerialName(OpenID.ResponseMode.QUERY)
    QUERY(OpenID.ResponseMode.QUERY),

    /** @see OpenID.ResponseMode.FRAGMENT */
    @SerialName(OpenID.ResponseMode.FRAGMENT)
    FRAGMENT(OpenID.ResponseMode.FRAGMENT),

    /** @see OpenID.ResponseMode.FORM_POST */
    @SerialName(OpenID.ResponseMode.FORM_POST)
    FORM_POST(OpenID.ResponseMode.FORM_POST);

    override fun toString() = value
}

fun String.toResponseModeOrNull(): ResponseMode? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        OpenID.ResponseMode.QUERY,
        -> ResponseMode.QUERY

        OpenID.ResponseMode.FRAGMENT,
        -> ResponseMode.FRAGMENT

        OpenID.ResponseMode.FORM_POST,
        -> ResponseMode.FORM_POST

        else -> null
    }
}

fun Set<ResponseType>.defaultResponseModeOrNull(): ResponseMode? {
    return when (this) {
        ResponseTypeSet.CODE,
        ResponseTypeSet.NONE,
        -> ResponseMode.QUERY

        ResponseTypeSet.TOKEN,
        ResponseTypeSet.ID_TOKEN,
        ResponseTypeSet.ID_TOKEN_TOKEN,
        ResponseTypeSet.CODE_TOKEN,
        ResponseTypeSet.CODE_ID_TOKEN,
        ResponseTypeSet.CODE_ID_TOKEN_TOKEN,
        -> ResponseMode.FRAGMENT

        else
        -> null
    }
}
