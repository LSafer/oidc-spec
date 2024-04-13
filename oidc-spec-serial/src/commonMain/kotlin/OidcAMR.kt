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

/** @see OpenID.AMR */
@JvmInline
@Serializable
value class OidcAMR(val value: String) {
    companion object {
        /** @see OpenID.AMR.TOTP */
        val TOTP = OidcAMR(OpenID.AMR.TOTP)

        /** @see OpenID.AMR.FACE */
        val FACE = OidcAMR(OpenID.AMR.FACE)

        /** @see OpenID.AMR.FPT */
        val FPT = OidcAMR(OpenID.AMR.FPT)

        /** @see OpenID.AMR.GEO */
        val GEO = OidcAMR(OpenID.AMR.GEO)

        /** @see OpenID.AMR.HWK */
        val HWK = OidcAMR(OpenID.AMR.HWK)

        /** @see OpenID.AMR.IRIS */
        val IRIS = OidcAMR(OpenID.AMR.IRIS)

        /** @see OpenID.AMR.KBA */
        val KBA = OidcAMR(OpenID.AMR.KBA)

        /** @see OpenID.AMR.MCA */
        val MCA = OidcAMR(OpenID.AMR.MCA)

        /** @see OpenID.AMR.MFA */
        val MFA = OidcAMR(OpenID.AMR.MFA)

        /** @see OpenID.AMR.OTP */
        val OTP = OidcAMR(OpenID.AMR.OTP)

        /** @see OpenID.AMR.PIN */
        val PIN = OidcAMR(OpenID.AMR.PIN)

        /** @see OpenID.AMR.PWD */
        val PWD = OidcAMR(OpenID.AMR.PWD)

        /** @see OpenID.AMR.RBA */
        val RBA = OidcAMR(OpenID.AMR.RBA)

        /** @see OpenID.AMR.RETINA */
        val RETINA = OidcAMR(OpenID.AMR.RETINA)

        /** @see OpenID.AMR.SC */
        val SC = OidcAMR(OpenID.AMR.SC)

        /** @see OpenID.AMR.SMS */
        val SMS = OidcAMR(OpenID.AMR.SMS)

        /** @see OpenID.AMR.SWK */
        val SWK = OidcAMR(OpenID.AMR.SWK)

        /** @see OpenID.AMR.TEL */
        val TEL = OidcAMR(OpenID.AMR.TEL)

        /** @see OpenID.AMR.USER */
        val USER = OidcAMR(OpenID.AMR.USER)

        /** @see OpenID.AMR.VBM */
        val VBM = OidcAMR(OpenID.AMR.VBM)

        /** @see OpenID.AMR.WIA */
        val WIA = OidcAMR(OpenID.AMR.WIA)
    }

    override fun toString() = value
}

fun String.asOidcAMR(): OidcAMR {
    return OidcAMR(this)
}
