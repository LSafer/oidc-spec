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

/** @see OAuth.CodeChallengeMethod */
@JvmInline
@Serializable
value class CodeChallengeMethod(val value: String) {
    companion object {
        /** @see OAuth.CodeChallengeMethod.PLAIN */
        val PLAIN = CodeChallengeMethod(OAuth.CodeChallengeMethod.PLAIN)

        /** @see OAuth.CodeChallengeMethod.S256 */
        val S256 = CodeChallengeMethod(OAuth.CodeChallengeMethod.S256)
    }

    override fun toString() = value
}

fun String.asCodeChallengeMethod(): CodeChallengeMethod {
    return CodeChallengeMethod(this)
}
