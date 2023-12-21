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
 * JWK values registry for parameter `use`
 */
object JwkUse {
    // https://datatracker.ietf.org/doc/html/rfc7517#section-4.2

    /**
     * Use for Signature.
     */
    const val SIG = "sig"

    /**
     * Use for Encryption.
     */
    const val ENC = "enc"
}
