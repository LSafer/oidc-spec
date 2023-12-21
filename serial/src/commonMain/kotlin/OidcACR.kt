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
package net.lsafer.oidc.serial

import kotlinx.serialization.Serializable
import net.lsafer.oidc.openid.OpenID
import kotlin.jvm.JvmInline

/** @see OpenID.ACR */
@JvmInline
@Serializable
value class OidcACR(val value: String) {
    companion object {
        /** @see OpenID.ACR.ZERO */
        val ZERO = OidcACR(OpenID.ACR.ZERO)

        /** @see OpenID.ACR.URN_MACE_INCOMMON_IAP_BRONZE */
        val URN_MACE_INCOMMON_IAP_BRONZE = OidcACR(OpenID.ACR.URN_MACE_INCOMMON_IAP_BRONZE)

        /** @see OpenID.ACR.URN_MACE_INCOMMON_IAP_SILVER */
        val URN_MACE_INCOMMON_IAP_SILVER = OidcACR(OpenID.ACR.URN_MACE_INCOMMON_IAP_SILVER)
    }

    override fun toString() = value
}

fun String.toOidcACRSequence(): Sequence<OidcACR> {
    if (isEmpty()) return emptySequence()
    return splitToSequence(" ")
        .map { it.asOidcACR() }
}

fun String.asOidcACR(): OidcACR {
    return OidcACR(this)
}
