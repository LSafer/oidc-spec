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

/**
 * Jwt Header Names Registry
 */
object JwtHeader {
    // https://datatracker.ietf.org/doc/html/rfc7519#section-5.1

    /**
     * The "typ" (type) Header Parameter defined by [`JWS`] and [`JWE`] is used
     * by JWT applications to declare the media type [`IANA.MediaTypes`] of
     * this complete JWT.  This is intended for use by the JWT application
     * when values that are not JWTs could also be present in an application
     * data structure that can contain a JWT object; the application can use
     * this value to disambiguate among the different kinds of objects that
     * might be present.  It will typically not be used by applications when
     * it is already known that the object is a JWT.  This parameter is
     * ignored by JWT implementations; any processing of this parameter is
     * performed by the JWT application.  If present, it is RECOMMENDED that
     * its value be "JWT" to indicate that this object is a JWT.  While
     * media type names are not case sensitive, it is RECOMMENDED that "JWT"
     * always be spelled using uppercase characters for compatibility with
     * legacy implementations.  Use of this Header Parameter is OPTIONAL.
     */
    const val TYP = "typ"

    // https://datatracker.ietf.org/doc/html/rfc7519#section-5.2

    /**
     * The "cty" (content type) Header Parameter defined by [`JWS`] and [`JWE`]
     * is used by this specification to convey structural information about
     * the JWT.
     *
     * In the normal case in which nested signing or encryption operations
     * are not employed, the use of this Header Parameter is NOT
     * RECOMMENDED.  In the case that nested signing or encryption is
     * employed, this Header Parameter MUST be present; in this case, the
     * value MUST be "JWT", to indicate that a Nested JWT is carried in this
     * JWT.  While media type names are not case sensitive, it is
     * RECOMMENDED that "JWT" always be spelled using uppercase characters
     * for compatibility with legacy implementations.
     */
    const val CTY = "cty"

    // https://datatracker.ietf.org/doc/html/rfc7518

    /**
     * Algorithm
     */
    const val ALG = "alg"

    /**
     * Encryption Method
     */
    const val ENC = "enc"

    /**
     * JSON Web Key Url
     */
    const val JKU = "jku"

    /**
     * JSON Web Key
     */
    const val JWK = "jwk"

    // https://datatracker.ietf.org/doc/html/rfc7517

    /**
     * Key ID
     */
    const val KID = "kid"

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

    // ?

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
