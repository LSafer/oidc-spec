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

/** @see OpenID.Prompt */
@JvmInline
@Serializable
value class OidcPrompt(val value: String) {
    companion object {
        /** @see OpenID.Prompt.NONE */
        val NONE = OidcPrompt(OpenID.Prompt.NONE)

        /** @see OpenID.Prompt.LOGIN */
        val LOGIN = OidcPrompt(OpenID.Prompt.LOGIN)

        /** @see OpenID.Prompt.CONSENT */
        val CONSENT = OidcPrompt(OpenID.Prompt.CONSENT)

        /** @see OpenID.Prompt.SELECT_ACCOUNT */
        val SELECT_ACCOUNT = OidcPrompt(OpenID.Prompt.SELECT_ACCOUNT)

        /** @see OpenID.Prompt.CREATE */
        val CREATE = OidcPrompt(OpenID.Prompt.CREATE)
    }

    override fun toString() = value
}

fun String.asOidcPrompt(): OidcPrompt {
    return OidcPrompt(this)
}

fun String.toOidcPromptSequence(): Sequence<OidcPrompt> {
    if (isEmpty()) return emptySequence()
    return splitToSequence(" ").map { it.asOidcPrompt() }
}
