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
 * JWK values registry for parameter `kty`
 */
object JwkType {
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
