package net.lsafer.oidc.serial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.lsafer.oidc.openid.OpenID

@Serializable
enum class ClientAuthentication(val value: String) {
    @SerialName(OpenID.ClientAuthentication.CLIENT_SECRET_BASIC)
    CLIENT_SECRET_BASIC(OpenID.ClientAuthentication.CLIENT_SECRET_BASIC),

    @SerialName(OpenID.ClientAuthentication.CLIENT_SECRET_POST)
    CLIENT_SECRET_POST(OpenID.ClientAuthentication.CLIENT_SECRET_POST),

    @SerialName(OpenID.ClientAuthentication.CLIENT_SECRET_JWT)
    CLIENT_SECRET_JWT(OpenID.ClientAuthentication.CLIENT_SECRET_JWT),

    @SerialName(OpenID.ClientAuthentication.PRIVATE_KEY_JWT)
    PRIVATE_KEY_JWT(OpenID.ClientAuthentication.PRIVATE_KEY_JWT),

    @SerialName(OpenID.ClientAuthentication.NONE)
    NONE(OpenID.ClientAuthentication.NONE);

    override fun toString() = value
}

fun String.toClientAuthenticationOrNull(): ClientAuthentication? {
    return when (this) {
        OpenID.ClientAuthentication.CLIENT_SECRET_BASIC,
        -> ClientAuthentication.CLIENT_SECRET_BASIC

        OpenID.ClientAuthentication.CLIENT_SECRET_POST,
        -> ClientAuthentication.CLIENT_SECRET_POST

        OpenID.ClientAuthentication.CLIENT_SECRET_JWT,
        -> ClientAuthentication.CLIENT_SECRET_JWT

        OpenID.ClientAuthentication.PRIVATE_KEY_JWT,
        -> ClientAuthentication.PRIVATE_KEY_JWT

        OpenID.ClientAuthentication.NONE,
        -> ClientAuthentication.NONE

        else -> null
    }
}
