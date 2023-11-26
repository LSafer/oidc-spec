package net.lsafer.identity.jose

object JwkType {
    /** from `org.jose4j.jwk.RsaJsonWebKey` */

    /**
     * RSA
     */
    const val RSA = "RSA"

    /** from `org.jose4j.jwk.EllipticCurveJsonWebKey` */

    /**
     * Elliptic Curve
     */
    const val EC = "EC"

    /** from `org.jose4j.jwk.OctetKeyPairJsonWebKey` */

    /**
     * Octet Key Pair
     */
    const val OKP = "OKP"

    /** from `org.jose4j.jwk.OctetSequenceJsonWebKey` */

    /**
     * Octet Sequence
     */
    const val OCT = "oct"
}
