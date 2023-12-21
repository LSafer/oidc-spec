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
import net.lsafer.oidc.oauth.PKCE

/** @see PKCE.CodeChallengeMethod */
@Serializable
enum class CodeChallengeMethod(val value: String) {
    /** @see PKCE.CodeChallengeMethod.PLAIN */
    @SerialName(PKCE.CodeChallengeMethod.PLAIN)
    PLAIN(PKCE.CodeChallengeMethod.PLAIN),

    /** @see PKCE.CodeChallengeMethod.S256 */
    @SerialName(PKCE.CodeChallengeMethod.S256)
    S256(PKCE.CodeChallengeMethod.S256);

    override fun toString() = value
}

fun String.toCodeChallengeMethodOrNull(): CodeChallengeMethod? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        PKCE.CodeChallengeMethod.PLAIN,
        -> CodeChallengeMethod.PLAIN

        PKCE.CodeChallengeMethod.S256,
        -> CodeChallengeMethod.S256

        else -> null
    }
}
