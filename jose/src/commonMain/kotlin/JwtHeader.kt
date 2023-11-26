package net.lsafer.identity.jose

/**
 * The names of jwt header claims
 */
object JwtHeader {
    // ???

    /**
     * Algorithm
     */
    const val ALG = "alg"

    /**
     * Encryption Method
     */
    const val ENC = "enc"

    /**
     * Key ID
     */
    const val KID = "kid"

    /**
     * Type
     */
    const val TYP = "typ"

    /**
     * Content Type
     */
    const val CTY = "cty"

    /**
     * JSON Web Key Url
     */
    const val JKU = "jku"

    /**
     * JSON Web Key
     */
    const val JWK = "jwk"

    /**
     * X509 Certificate Chain
     */
    const val X5C = "x5c"

    /**
     * X509 Certificate thumbprint
     */
    const val X5T = "x5t"

    /**
     * X509 Certificate SHA256 Thumbprint
     */
    const val X5T_S256 = "x5t#S256"

    /**
     * X509 Url
     */
    const val X5U = "x5u"

    /**
     * Ephemeral Public Key
     */
    const val EPK = "epk"

    /**
     * Agreement Party U Info
     */
    const val APU = "apu"

    /**
     * Agreement Party V Info
     */
    const val APV = "apv"

    /**
     * ZIP
     */
    const val ZIP = "zip"

    /**
     * PBES2 Salt Input
     */
    const val P2S = "p2s"

    /**
     * PBES2 Iteration Count
     */
    const val P2C = "p2c"

    /**
     * Initialization Vector
     */
    const val IV = "iv"

    /**
     * Authentication Tag
     */
    const val TAG = "tag"

    /**
     * Critical
     */
    const val CRIT = "crit"
}
