package net.lsafer.oidc.serial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.lsafer.oidc.oauth.OAuth

@Serializable
enum class GrantType(val value: String) {
    @SerialName(OAuth.GrantType.AUTHORIZATION_CODE)
    AUTHORIZATION_CODE(OAuth.GrantType.AUTHORIZATION_CODE),

    @SerialName(OAuth.GrantType.IMPLICIT)
    IMPLICIT(OAuth.GrantType.IMPLICIT),

    @SerialName(OAuth.GrantType.CLIENT_CREDENTIALS)
    CLIENT_CREDENTIALS(OAuth.GrantType.CLIENT_CREDENTIALS),

    @SerialName(OAuth.GrantType.REFRESH_TOKEN)
    REFRESH_TOKEN(OAuth.GrantType.REFRESH_TOKEN),

    @SerialName(OAuth.GrantType.PASSWORD)
    PASSWORD(OAuth.GrantType.PASSWORD);

    override fun toString() = value
}

fun ResponseType.associatedGrantTypeOrNull(): GrantType? {
    return when (this) {
        ResponseType.NONE,
        -> null

        ResponseType.CODE,
        -> GrantType.AUTHORIZATION_CODE

        ResponseType.ID_TOKEN,
        ResponseType.TOKEN,
        -> GrantType.IMPLICIT
    }
}

fun String.toGrantTypeOrNull(): GrantType? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        OAuth.GrantType.AUTHORIZATION_CODE,
        -> GrantType.AUTHORIZATION_CODE

        OAuth.GrantType.IMPLICIT,
        -> GrantType.IMPLICIT

        OAuth.GrantType.CLIENT_CREDENTIALS,
        -> GrantType.CLIENT_CREDENTIALS

        OAuth.GrantType.REFRESH_TOKEN,
        -> GrantType.REFRESH_TOKEN

        OAuth.GrantType.PASSWORD,
        -> GrantType.PASSWORD

        else -> null
    }
}
