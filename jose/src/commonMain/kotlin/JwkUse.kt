package net.lsafer.identity.jose

/**
 * The names of jwk usages.
 */
object JwkUse {
    /** from `org.jose4j.jwk.Use`  */

    /**
     * Use for Signature.
     */
    const val SIG = "sig"

    /**
     * Use for Encryption.
     */
    const val ENC = "enc"
}
