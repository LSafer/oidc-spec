package net.lsafer.identity.serial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.lsafer.identity.openid.OpenID

@Serializable
enum class SubjectType(val value: String) {
    @SerialName(OpenID.SubjectType.PUBLIC)
    PUBLIC(OpenID.SubjectType.PUBLIC),

    @SerialName(OpenID.SubjectType.PAIRWISE)
    PAIRWISE(OpenID.SubjectType.PAIRWISE);

    override fun toString() = value
}

fun String.toSubjectTypeOrNull(): SubjectType? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        OpenID.SubjectType.PUBLIC,
        -> SubjectType.PUBLIC

        OpenID.SubjectType.PAIRWISE,
        -> SubjectType.PAIRWISE

        else -> null
    }
}
