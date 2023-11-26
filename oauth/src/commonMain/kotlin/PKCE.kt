package net.lsafer.identity.oauth

/**
 * Proof Key for Code Exchange by OAuth Public Clients
 *
 * [RFC7636](https://datatracker.ietf.org/doc/html/rfc7636)
 */
object PKCE {
    // parameters

    object Param {
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

    //

    object CodeChallengeMethod {
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
