package net.lsafer.oidc.serial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.lsafer.oidc.openid.OpenID

@Serializable
enum class OidcPrompt(val value: String) {
    @SerialName(OpenID.Prompt.NONE)
    NONE(OpenID.Prompt.NONE),

    @SerialName(OpenID.Prompt.LOGIN)
    LOGIN(OpenID.Prompt.LOGIN),

    @SerialName(OpenID.Prompt.CONSENT)
    CONSENT(OpenID.Prompt.CONSENT),

    @SerialName(OpenID.Prompt.SELECT_ACCOUNT)
    SELECT_ACCOUNT(OpenID.Prompt.SELECT_ACCOUNT),

    @SerialName(OpenID.Prompt.CREATE)
    CREATE(OpenID.Prompt.CREATE);

    override fun toString() = value
}

fun String.toOidcPromptSequence(): Sequence<OidcPrompt> {
    if (isEmpty()) return emptySequence()
    return splitToSequence(" ")
        .mapNotNull { it.toOidcPromptOrNull() }
}

fun String.toOidcPromptOrNull(): OidcPrompt? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        OpenID.Prompt.NONE,
        -> OidcPrompt.NONE

        OpenID.Prompt.LOGIN,
        -> OidcPrompt.LOGIN

        OpenID.Prompt.CONSENT,
        -> OidcPrompt.CONSENT

        OpenID.Prompt.SELECT_ACCOUNT,
        -> OidcPrompt.SELECT_ACCOUNT

        OpenID.Prompt.CREATE,
        -> OidcPrompt.CREATE

        else -> null
    }
}
