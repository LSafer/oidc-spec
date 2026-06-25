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
package net.lsafer.oidc.jose

@Deprecated("Has Being Replaced", ReplaceWith("JwkParam.KeyOps", "net.lsafer.oidc.jose.JwkParam"))
typealias JwkOperation = JwkParam.KeyOps

@Deprecated("Has Being Replaced", ReplaceWith("JwkParam.Kty", "net.lsafer.oidc.jose.JwkParam"))
typealias JwkType = JwkParam.Kty

@Deprecated("Has Being Replaced", ReplaceWith("JwkParam.Use", "net.lsafer.oidc.jose.JwkParam"))
typealias JwkUse = JwkParam.Use

/**
 * Jwk Parameter Names Registry
 */
object JwkParam {
    // https://datatracker.ietf.org/doc/html/rfc7517#section-4

    /**
     * The "kty" (key type) parameter identifies the cryptographic algorithm
     * family used with the key, such as "RSA" or "EC". "kty" values should
     * either be registered in the IANA "JSON Web Key Types" registry established
     * by [`JWA`] or be a value that contains a Collision-Resistant Name.
     * The "kty" value is a case-sensitive string. This member MUST be
     * present in a JWK.
     *
     * @see <a href=https://datatracker.ietf.org/doc/html/rfc7517#section-4.1>RFC7517 4.1</a>
     */
    const val KTY = "kty"

    /**
     * JWK values registry for parameter [JwkParam.KTY]
     */
    object Kty {
        // https://datatracker.ietf.org/doc/html/rfc7518#section-6.1

        /**
         * RSA
         */
        const val RSA = "RSA"

        /**
         * Elliptic Curve
         */
        const val EC = "EC"

        /**
         * Octet Sequence
         */
        const val OCT = "oct"

        // ?

        /**
         * Octet Key Pair
         */
        const val OKP = "OKP"
    }

    /**
     * The "use" (public key use) parameter identifies the intended use of
     * the public key. The "use" parameter is employed to indicate whether
     * a public key is used for encrypting data or verifying the signature
     * on data.
     *
     * @see <a href=https://datatracker.ietf.org/doc/html/rfc7517#section-4.2>RFC7517 4.2</a>
     */
    const val USE = "use"

    /**
     * JWK values registry for parameter [JwkParam.USE]
     */
    object Use {
        // https://datatracker.ietf.org/doc/html/rfc7517#section-4.2

        /**
         * Use for Signature
         */
        const val SIG = "sig"

        /**
         * Use for Encryption
         */
        const val ENC = "enc"
    }

    /**
     * The "key_ops" (key operations) parameter identifies the operation(s)
     * for which the key is intended to be used. The "key_ops" parameter is
     * intended for use cases in which public, private, or symmetric keys
     * may be present.
     *
     * @see <a href=https://datatracker.ietf.org/doc/html/rfc7517#section-4.3>RFC7517 4.3</a>
     */
    const val KEY_OPS = "key_ops"

    /**
     * JWK values registry for [JwkParam.KEY_OPS]
     */
    object KeyOps {
        // https://datatracker.ietf.org/doc/html/rfc7517#section-4.3

        /**
         * Compute digital signature or MAC
         */
        const val SIGN = "sign"

        /**
         * Verify digital signature or MAC
         */
        const val VERIFY = "verify"

        /**
         * Encrypt Content
         */
        const val ENCRYPT = "encrypt"

        /**
         * Decrypt content and validate decryption, if applicable
         */
        const val DECRYPT = "decrypt"

        /**
         * Encrypt Key
         */
        const val WRAP_KEY = "wrapKey"

        /**
         * Decrypt key and validate decryption, if applicable
         */
        const val UNWRAP_KEY = "unwrapKey"

        /**
         * Derive Key
         */
        const val DERIVE_KEY = "deriveKey"

        /**
         * Derive bits not to be used as a key
         */
        const val DERIVE_BITS = "deriveBits"
    }

    /**
     * The "alg" (algorithm) parameter identifies the algorithm intended for
     * use with the key. The values used should either be registered in the
     * IANA "JSON Web Signature and Encryption Algorithms" registry established
     * by [`JWA`] or be a value that contains a Collision-Resistant Name.
     * The "alg" value is a case-sensitive ASCII string.
     * Use of this member is OPTIONAL.
     *
     * @see <a href=https://datatracker.ietf.org/doc/html/rfc7517#section-4.4>RFC7517 4.4</a>
     */
    const val ALG = "alg"

    /**
     * The "kid" (key ID) parameter is used to match a specific key. This
     * is used, for instance, to choose among a set of keys within a JWK Set
     * during key rollover. The structure of the "kid" value is unspecified.
     * When "kid" values are used within a JWK Set, different keys within the
     * JWK Set SHOULD use distinct "kid" values. (One example in which different
     * keys might use the same "kid" value is if they have different "kty" (key type)
     * values but are considered to be equivalent alternatives by the application
     * using them.)  The "kid" value is a case-sensitive string.
     * Use of this member is OPTIONAL.
     * When used with JWS or JWE, the "kid" value is used to match a JWS or
     * JWE "kid" Header Parameter value.
     *
     * @see <a href=https://datatracker.ietf.org/doc/html/rfc7517#section-4.5>RFC7517 4.5</a>
     */
    const val KID = "kid"

    /**
     * The "x5u" (X.509 URL) parameter is a URI [`RFC3986`] that refers to a
     * resource for an X.509 public key certificate or certificate chain
     * [`RFC5280`]. The identified resource MUST provide a representation of
     * the certificate or certificate chain that conforms to RFC 5280
     * [`RFC5280`] in PEM-encoded form, with each certificate delimited as
     * specified in Section 6.1 of RFC 4945 [`RFC4945`]. The key in the first
     * certificate MUST match the public key represented by other members of
     * the JWK. The protocol used to acquire the resource MUST provide
     * integrity protection; an HTTP GET request to retrieve the certificate
     * MUST use TLS [`RFC2818`] [`RFC5246`]; the identity of the server MUST be
     * validated, as per Section 6 of RFC 6125 [`RFC6125`]. Use of this
     * member is OPTIONAL.
     *
     * @see <a href=https://datatracker.ietf.org/doc/html/rfc7517#section-4.6>RFC7517 4.6</a>
     */
    const val X5U = "x5u"

    /**
     * The "x5c" (X.509 certificate chain) parameter contains a chain of one
     * or more PKIX certificates [`RFC5280`]. The certificate chain is
     * represented as a JSON array of certificate value strings. Each
     * string in the array is a base64-encoded (Section 4 of [`RFC4648`] --
     * not base64url-encoded) DER [`ITU.X690.1994`] PKIX certificate value.
     * The PKIX certificate containing the key value MUST be the first
     * certificate. This MAY be followed by additional certificates, with
     * each subsequent certificate being the one used to certify the
     * previous one. The key in the first certificate MUST match the public
     * key represented by other members of the JWK. Use of this member is
     * OPTIONAL.
     *
     * @see <a href=https://datatracker.ietf.org/doc/html/rfc7517#section-4.7>RFC7517 4.7</a>
     */
    const val X5C = "x5c"

    /**
     * The "x5t" (X.509 certificate SHA-1 thumbprint) parameter is a
     * base64url-encoded SHA-1 thumbprint (a.k.a. digest) of the DER
     * encoding of an X.509 certificate [`RFC5280`]. Note that certificate
     * thumbprints are also sometimes known as certificate fingerprints.
     * The key in the certificate MUST match the public key represented by
     * other members of the JWK. Use of this member is OPTIONAL.
     *
     * @see <a href=https://datatracker.ietf.org/doc/html/rfc7517#section-4.8>RFC7517 4.8</a>
     */
    const val X5T = "x5t"

    /**
     * The "x5t#S256" (X.509 certificate SHA-256 thumbprint) parameter is a
     * base64url-encoded SHA-256 thumbprint (a.k.a. digest) of the DER
     * encoding of an X.509 certificate [`RFC5280`]. Note that certificate
     * thumbprints are also sometimes known as certificate fingerprints.
     * The key in the certificate MUST match the public key represented by
     * other members of the JWK. Use of this member is OPTIONAL.
     *
     * @see <a href=https://datatracker.ietf.org/doc/html/rfc7517#section-4.9>RFC7517 4.9</a>
     */
    const val X5T_S256 = "x5t#S256"
}
