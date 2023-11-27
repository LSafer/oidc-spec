package net.lsafer.identity.serial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.lsafer.identity.oauth.PKCE

/**
 * @see PKCE.CodeChallengeMethod
 */
@Serializable
enum class CodeChallengeMethod(val value: String) {
    @SerialName(PKCE.CodeChallengeMethod.PLAIN)
    PLAIN(PKCE.CodeChallengeMethod.PLAIN),

    @SerialName(PKCE.CodeChallengeMethod.S256)
    S256(PKCE.CodeChallengeMethod.S256);

    override fun toString() = value
}

fun String.toCodeChallengeMethodOrNull(): CodeChallengeMethod? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        PKCE.CodeChallengeMethod.PLAIN,
        -> CodeChallengeMethod.PLAIN

        PKCE.CodeChallengeMethod.S256,
        -> CodeChallengeMethod.S256

        else -> null
    }
}
