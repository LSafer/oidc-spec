package net.lsafer.oidc.jose

object JwtType {
    const val JWT = "JWT"

    // https://datatracker.ietf.org/doc/html/rfc8725#section-3.11

    const val AT_JWT = "at+jwt"

    // https://www.iana.org/assignments/media-types/media-types.xhtml#application

    const val DPOP_JWT = "dpop+jwt"

    const val LOGOUT_JWT = "logout+jwt"

    const val OAUTH_AUTHZ_REQ_JWT = "oauth-authz-req+jwt"

    const val SECEVENT_JWT = "secevent+jwt"

    const val TOKEN_INTROSPECTION_JWT = "token-introspection+jwt"

    // https://connect2id.com/products/server/docs/guides/explicitly-typed-id-token-and-userinfo-jwt

    const val ID_TOKEN_JWT = "id_token+jwt"

    // Extensions

    /**
     * Identity Token Jwt. (OpenID Identity Token)
     */
    const val IT_JWT = "it+jwt"

    /**
     * Request Object Jwt. (OpenID Request Object)
     *
     * Consider allowing [OAUTH_AUTHZ_REQ_JWT] as well.
     */
    const val RO_JWT = "ro+jwt"

    /**
     * User Info Jwt. (OpenID Userinfo Endpoint Response)
     */
    const val UI_JWT = "ui+jwt"

    /**
     * Tenant Object Jwt.
     */
    const val TO_JWT = "to+jwt"
}
