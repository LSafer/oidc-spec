package net.lsafer.oidc.client

import net.lsafer.oidc.serial.OidcScope

data class AuthorizationRequest(
    val redirectUri: String,
    val state: String? = null,
    val codeVerifier: String? = null,
    val scope: Set<OidcScope> = setOf(OidcScope.OPENID),
)
