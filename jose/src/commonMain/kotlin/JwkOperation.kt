package net.lsafer.identity.jose

object JwkOperation {
    // from https://datatracker.ietf.org/doc/html/rfc7517#section-4.3

    /**
     * compute digital signature or MAC
     */
    const val SIGN = "sign"

    /**
     * verify digital signature or MAC
     */
    const val VERIFY = "verify"

    /**
     * encrypt content
     */
    const val ENCRYPT = "encrypt"

    /**
     * decrypt content and validate decryption, if applicable
     */
    const val DECRYPT = "decrypt"

    /**
     * encrypt key
     */
    const val WRAP_KEY = "wrapKey"

    /**
     * decrypt key and validate decryption, if applicable
     */
    const val UNWRAP_KEY = "unwrapKey"

    /**
     * derive key
     */
    const val DERIVE_KEY = "deriveKey"

    /**
     * derive bits not to be used as a key
     */
    const val DERIVE_BITS = "deriveBits"
}
