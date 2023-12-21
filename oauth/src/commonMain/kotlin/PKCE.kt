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
package net.lsafer.oidc.oauth

/**
 * PKCE Constants.
 */
object PKCE {
    /**
     * PKCE Parameters Registry.
     */
    object Param {
        // https://datatracker.ietf.org/doc/html/rfc7636

        /**
         * REQUIRED. Code challenge.
         */
        const val CODE_CHALLENGE = "code_challenge"

        /**
         * OPTIONAL, defaults to "plain" if not present in the request.
         * Code verifier transformation method is "S256" or "plain".
         */
        const val CODE_CHALLENGE_METHOD = "code_challenge_method"

        /**
         * REQUIRED. Code verifier
         */
        const val CODE_VERIFIER = "code_verifier"
    }

    /**
     * PKCE values registry for parameter `code_challenge_method`
     */
    object CodeChallengeMethod {
        // https://datatracker.ietf.org/doc/html/rfc7636

        /**
         * code_challenge = code_verifier
         */
        const val PLAIN = "plain"

        /**
         * code_challenge = BASE64URL-ENCODE(SHA256(ASCII(code_verifier)))
         */
        const val S256 = "S256"
    }
}
