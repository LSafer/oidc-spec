package net.lsafer.oidc.serial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.lsafer.oidc.openid.OpenID

@Serializable
enum class ResponseMode(val value: String) {
    @SerialName(OpenID.ResponseMode.QUERY)
    QUERY(OpenID.ResponseMode.QUERY),

    @SerialName(OpenID.ResponseMode.FRAGMENT)
    FRAGMENT(OpenID.ResponseMode.FRAGMENT),

    @SerialName(OpenID.ResponseMode.FORM_POST)
    FORM_POST(OpenID.ResponseMode.FORM_POST);

    override fun toString() = value
}

fun String.toResponseModeOrNull(): ResponseMode? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        OpenID.ResponseMode.QUERY,
        -> ResponseMode.QUERY

        OpenID.ResponseMode.FRAGMENT,
        -> ResponseMode.FRAGMENT

        OpenID.ResponseMode.FORM_POST,
        -> ResponseMode.FORM_POST

        else -> null
    }
}

fun Set<ResponseType>.defaultResponseModeOrNull(): ResponseMode? {
    return when (this) {
        ResponseTypeSet.CODE,
        ResponseTypeSet.NONE,
        -> ResponseMode.QUERY

        ResponseTypeSet.TOKEN,
        ResponseTypeSet.ID_TOKEN,
        ResponseTypeSet.ID_TOKEN_TOKEN,
        ResponseTypeSet.CODE_TOKEN,
        ResponseTypeSet.CODE_ID_TOKEN,
        ResponseTypeSet.CODE_ID_TOKEN_TOKEN,
        -> ResponseMode.FRAGMENT

        else
        -> null
    }
}
