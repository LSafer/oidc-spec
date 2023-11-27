package net.lsafer.identity.serial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.lsafer.identity.openid.OpenID

@Serializable
enum class OidcDisplay(val value: String) {
    @SerialName(OpenID.Display.PAGE)
    PAGE(OpenID.Display.PAGE),

    @SerialName(OpenID.Display.POPUP)
    POPUP(OpenID.Display.POPUP),

    @SerialName(OpenID.Display.TOUCH)
    TOUCH(OpenID.Display.TOUCH),

    @SerialName(OpenID.Display.WAP)
    WAP(OpenID.Display.WAP);

    override fun toString() = value
}

fun String.toOidcDisplayOrNull(): OidcDisplay? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        OpenID.Display.PAGE
        -> OidcDisplay.PAGE

        OpenID.Display.POPUP
        -> OidcDisplay.POPUP

        OpenID.Display.TOUCH
        -> OidcDisplay.TOUCH

        OpenID.Display.WAP
        -> OidcDisplay.WAP

        else -> null
    }
}
