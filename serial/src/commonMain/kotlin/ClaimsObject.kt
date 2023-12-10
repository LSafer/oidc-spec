package net.lsafer.oidc.serial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import net.lsafer.oidc.openid.OpenID

// https://openid.net/specs/openid-connect-core-1_0.html#ClaimsParameter

@Serializable
data class IndividualClaimRequest(
    @SerialName(OpenID.Param.Claims.ESSENTIAL)
    val essential: Boolean? = null,
    @SerialName(OpenID.Param.Claims.VALUE)
    val value: String? = null,
    @SerialName(OpenID.Param.Claims.VALUES)
    val values: List<String>? = null,
)

@Serializable
data class ClaimsObject(
    @SerialName(OpenID.Param.Claims.USERINFO)
    val userinfo: Map<String, IndividualClaimRequest?> = emptyMap(),
    @SerialName(OpenID.Param.Claims.ID_TOKEN)
    val identity: Map<String, IndividualClaimRequest?> = emptyMap(),
)

fun String.decodeClaimsObjectOrNull(): ClaimsObject? {
    return try {
        Json.decodeFromString(this)
    } catch (_: SerializationException) {
        null
    } catch (_: IllegalArgumentException) {
        null
    }
}
