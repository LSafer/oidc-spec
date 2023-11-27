package net.lsafer.identity.serial

import kotlinx.serialization.Serializable
import net.lsafer.identity.openid.OpenID
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class OidcAMR(val value: String) {
    companion object {
        val TOTP = OidcAMR(OpenID.AMR.TOTP)
        val FACE = OidcAMR(OpenID.AMR.FACE)
        val FPT = OidcAMR(OpenID.AMR.FPT)
        val GEO = OidcAMR(OpenID.AMR.GEO)
        val HWK = OidcAMR(OpenID.AMR.HWK)
        val IRIS = OidcAMR(OpenID.AMR.IRIS)
        val KBA = OidcAMR(OpenID.AMR.KBA)
        val MCA = OidcAMR(OpenID.AMR.MCA)
        val MFA = OidcAMR(OpenID.AMR.MFA)
        val OTP = OidcAMR(OpenID.AMR.OTP)
        val PIN = OidcAMR(OpenID.AMR.PIN)
        val PWD = OidcAMR(OpenID.AMR.PWD)
        val RBA = OidcAMR(OpenID.AMR.RBA)
        val RETINA = OidcAMR(OpenID.AMR.RETINA)
        val SC = OidcAMR(OpenID.AMR.SC)
        val SMS = OidcAMR(OpenID.AMR.SMS)
        val SWK = OidcAMR(OpenID.AMR.SWK)
        val TEL = OidcAMR(OpenID.AMR.TEL)
        val USER = OidcAMR(OpenID.AMR.USER)
        val VBM = OidcAMR(OpenID.AMR.VBM)
        val WIA = OidcAMR(OpenID.AMR.WIA)
    }

    override fun toString() = value
}

fun String.asOidcAMR(): OidcAMR {
    return OidcAMR(this)
}
