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

/** @see OpenID.Prompt */
@Serializable
enum class OidcPrompt(val value: String) {
    /** @see OpenID.Prompt.NONE */
    @SerialName(OpenID.Prompt.NONE)
    NONE(OpenID.Prompt.NONE),

    /** @see OpenID.Prompt.LOGIN */
    @SerialName(OpenID.Prompt.LOGIN)
    LOGIN(OpenID.Prompt.LOGIN),

    /** @see OpenID.Prompt.CONSENT */
    @SerialName(OpenID.Prompt.CONSENT)
    CONSENT(OpenID.Prompt.CONSENT),

    /** @see OpenID.Prompt.SELECT_ACCOUNT */
    @SerialName(OpenID.Prompt.SELECT_ACCOUNT)
    SELECT_ACCOUNT(OpenID.Prompt.SELECT_ACCOUNT),

    /** @see OpenID.Prompt.CREATE */
    @SerialName(OpenID.Prompt.CREATE)
    CREATE(OpenID.Prompt.CREATE);

    override fun toString() = value
}

fun String.toOidcPromptSequence(): Sequence<OidcPrompt> {
    if (isEmpty()) return emptySequence()
    return splitToSequence(" ")
        .mapNotNull { it.toOidcPromptOrNull() }
}

fun String.toOidcPromptOrNull(): OidcPrompt? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        OpenID.Prompt.NONE,
        -> OidcPrompt.NONE

        OpenID.Prompt.LOGIN,
        -> OidcPrompt.LOGIN

        OpenID.Prompt.CONSENT,
        -> OidcPrompt.CONSENT

        OpenID.Prompt.SELECT_ACCOUNT,
        -> OidcPrompt.SELECT_ACCOUNT

        OpenID.Prompt.CREATE,
        -> OidcPrompt.CREATE

        else -> null
    }
}
