package net.lsafer.oidc.client

import kotlinx.serialization.Serializable
import net.lsafer.oidc.serial.OidcScope

@Serializable
data class AuthorizationRequest(
    val redirectUri: String,
    val state: String? = null,
    val codeVerifier: String? = null,
    val scope: Set<OidcScope> = setOf(OidcScope.OPENID),
)
