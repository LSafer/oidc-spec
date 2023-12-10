package net.lsafer.oidc.serial

import kotlinx.serialization.Serializable
import net.lsafer.oidc.openid.OpenID
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class OidcACR(val value: String) {
    companion object {
        val ZERO = OidcACR(OpenID.ACR.ZERO)
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
