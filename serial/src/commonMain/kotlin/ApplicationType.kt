package net.lsafer.identity.serial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.lsafer.identity.openid.OpenID

@Serializable
enum class ApplicationType(val value: String) {
    @SerialName(OpenID.ApplicationType.WEB)
    WEB(OpenID.ApplicationType.WEB),

    @SerialName(OpenID.ApplicationType.NATIVE)
    NATIVE(OpenID.ApplicationType.NATIVE);

    override fun toString() = value
}

fun String.toApplicationTypeOrNull(): ApplicationType? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        OpenID.ApplicationType.WEB,
        -> ApplicationType.WEB

        OpenID.ApplicationType.NATIVE,
        -> ApplicationType.NATIVE

        else -> null
    }
}
