package net.lsafer.oidc.serial

import kotlinx.serialization.Serializable
import net.lsafer.oidc.openid.OpenID
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class OidcScope(val value: String) {
    companion object {
        val OPENID = OidcScope(OpenID.Scope.OPENID)
        val PROFILE = OidcScope(OpenID.Scope.PROFILE)
        val EMAIL = OidcScope(OpenID.Scope.EMAIL)
        val ADDRESS = OidcScope(OpenID.Scope.ADDRESS)
        val PHONE = OidcScope(OpenID.Scope.PHONE)
        val OFFLINE_ACCESS = OidcScope(OpenID.Scope.OFFLINE_ACCESS)
    }

    override fun toString() = value
}

fun String.toOidcScopeSequence(): Sequence<OidcScope> {
    if (isBlank()) return emptySequence()
    return splitToSequence(" ")
        .map { it.asOidcScope() }
}

fun String.asOidcScope(): OidcScope {
    return OidcScope(this)
}
