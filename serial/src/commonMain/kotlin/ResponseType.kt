package net.lsafer.identity.serial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import net.lsafer.identity.oauth.OAuth
import net.lsafer.identity.openid.OpenID

@Serializable
enum class ResponseType(val value: String) {
    @SerialName(OAuth.ResponseType.CODE)
    CODE(OAuth.ResponseType.CODE),

    @SerialName(OAuth.ResponseType.TOKEN)
    TOKEN(OAuth.ResponseType.TOKEN),

    @SerialName(OpenID.ResponseType.NONE)
    NONE(OpenID.ResponseType.NONE),

    @SerialName(OpenID.ResponseType.ID_TOKEN)
    ID_TOKEN(OpenID.ResponseType.ID_TOKEN);

    override fun toString() = value
}

object ResponseTypeSet {
    val CODE = setOf(ResponseType.CODE)
    val TOKEN = setOf(ResponseType.TOKEN)
    val NONE = setOf(ResponseType.NONE)
    val ID_TOKEN = setOf(ResponseType.ID_TOKEN)
    val ID_TOKEN_TOKEN = setOf(ResponseType.ID_TOKEN, ResponseType.TOKEN)
    val CODE_TOKEN = setOf(ResponseType.CODE, ResponseType.TOKEN)
    val CODE_ID_TOKEN = setOf(ResponseType.CODE, ResponseType.ID_TOKEN)
    val CODE_ID_TOKEN_TOKEN = setOf(ResponseType.CODE, ResponseType.ID_TOKEN, ResponseType.TOKEN)
}

fun String.toResponseTypeSetOrNull(): Set<ResponseType>? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        OAuth.ResponseType.CODE,
        -> ResponseTypeSet.CODE

        OAuth.ResponseType.TOKEN,
        -> ResponseTypeSet.TOKEN

        OpenID.ResponseType.NONE,
        -> ResponseTypeSet.NONE

        OpenID.ResponseType.ID_TOKEN,
        -> ResponseTypeSet.ID_TOKEN

        OpenID.ResponseType.ID_TOKEN_TOKEN,
        "token id_token",
        -> ResponseTypeSet.ID_TOKEN_TOKEN

        OpenID.ResponseType.CODE_TOKEN,
        "token code",
        -> ResponseTypeSet.CODE_TOKEN

        OpenID.ResponseType.CODE_ID_TOKEN,
        "id_token code",
        -> ResponseTypeSet.CODE_ID_TOKEN

        OpenID.ResponseType.CODE_ID_TOKEN_TOKEN,
        "code token id_token",
        "id_token code token",
        "id_token token code",
        "token code id_token",
        "token id_token code",
        -> ResponseTypeSet.CODE_ID_TOKEN_TOKEN

        else -> null
    }
}
