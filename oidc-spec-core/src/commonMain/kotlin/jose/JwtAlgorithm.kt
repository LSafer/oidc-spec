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
 * JWT values registry for common parameter `alg`
 */
object JwtAlgorithm {
    // https://datatracker.ietf.org/doc/html/rfc7518#section-3.1

    /**
     * HMAC with SHA256
     */
    const val HS256 = "HS256"

    /**
     * HMAC with SHA384
     */
    const val HS384 = "HS384"

    /**
     * HMAC with SHA512
     */
    const val HS512 = "HS512"

    /**
     * RSA with SHA256
     */
    const val RS256 = "RS256"

    /**
     * RSA with SHA384
     */
    const val RS384 = "RS384"

    /**
     * RSA with SHA512
     */
    const val RS512 = "RS512"

    /**
     * ECDSA with P256 Curve and SHA256
     */
    const val ES256 = "ES256"

    /**
     * ECDSA with P384 Curve and SHA384
     */
    const val ES384 = "ES384"

    /**
     * ECDSA with P512 Curve and SHA512
     */
    const val ES512 = "ES512"

    /**
     * RSA PSS with SHA256
     */
    const val PS256 = "PS256"

    /**
     * RSA PSS with SHA384
     */
    const val PS384 = "PS384"

    /**
     * RSA PSS with SHA512
     */
    const val PS512 = "PS512"

    /**
     * No Signature
     */
    const val NONE = "none"

    // https://datatracker.ietf.org/doc/html/rfc7518#section-4.1

    /**
     * RSA1 5
     */
    const val RSA1_5 = "RSA1_5"

    /**
     * RSA OAEP
     */
    const val RSA_OAEP = "RSA-OAEP"

    /**
     * RSA OAEP 256
     */
    const val RSA_OAEP_256 = "RSA-OAEP-256"

    /**
     * A128KW
     */
    const val A128KW = "A128KW"

    /**
     * A192KW
     */
    const val A192KW = "A192KW"

    /**
     * A256KW
     */
    const val A256KW = "A256KW"

    /**
     * DIRECT
     */
    const val DIR = "dir"

    /**
     * ECDH ES
     */
    const val ECDH_ES = "ECDH-ES"

    /**
     * ECDH ES A128KW
     */
    const val ECDH_ES_A128KW = "ECDH-ES+A128KW"

    /**
     * ECDH ES A192KW
     */
    const val ECDH_ES_A192KW = "ECDH-ES+A192KW"

    /**
     * ECDH ES A256KW
     */
    const val ECDH_ES_A256KW = "ECDH-ES+A256KW"

    /**
     * A128GCMKW
     */
    const val A128GCMKW = "A128GCMKW"

    /**
     * A192GCMKW
     */
    const val A192GCMKW = "A192GCMKW"

    /**
     * A256GCMKW
     */
    const val A256GCMKW = "A256GCMKW"

    /**
     * PBES2 HS256 A128KW
     */
    const val PBES2_HS256_A128KW = "PBES2-HS256+A128KW"

    /**
     * PBES2 HS384 A192KW
     */
    const val PBES2_HS384_A192KW = "PBES2-HS384+A192KW"

    /**
     * PBES2 HS512 A256KW
     */
    const val PBES2_HS512_A256KW = "PBES2-HS512+A256KW"

    // https://datatracker.ietf.org/doc/html/rfc7518#section-5.1

    /**
     * AES 128 CBC HMAC SHA 256
     */
    const val A128CBC_HS256 = "A128CBC-HS256"

    /**
     * AES 192 CBC HMAC SHA 384
     */
    const val A192CBC_HS384 = "A192CBC-HS384"

    /**
     * AES 256 CBC HMAC SHA 512
     */
    const val A256CBC_HS512 = "A256CBC-HS512"

    /**
     * AES 128 GCM
     */
    const val A128GCM = "A128GCM"

    /**
     * AES 192 GCM
     */
    const val A192GCM = "A192GCM"

    /**
     * AES 256 GCM
     */
    const val A256GCM = "A256GCM"

    // ?

    /**
     * ECDSA with SECP256K1 Curve and SHA256
     */
    const val ES256K = "ES256K"

    @Suppress("ConstPropertyName")
    const val EdDSA = "EdDSA"
}
