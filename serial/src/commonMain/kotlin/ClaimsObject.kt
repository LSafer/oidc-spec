/*
 *	Copyright 2023 cufy.org and meemer.com
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package net.lsafer.oidc.serial

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import net.lsafer.oidc.openid.OpenID

// https://openid.net/specs/openid-connect-core-1_0.html#ClaimsParameter

/**
 * @see OpenID.Param.Claims.USERINFO
 * @see OpenID.Param.Claims.ID_TOKEN
 */
@Serializable
data class IndividualClaimRequest(
    /** @see OpenID.Param.Claims.ESSENTIAL */
    @SerialName(OpenID.Param.Claims.ESSENTIAL)
    val essential: Boolean? = null,

    /** @see OpenID.Param.Claims.VALUE */
    @SerialName(OpenID.Param.Claims.VALUE)
    val value: String? = null,

    /** @see OpenID.Param.Claims.VALUES */
    @SerialName(OpenID.Param.Claims.VALUES)
    val values: List<String>? = null,
)

/** @see OpenID.Param.CLAIMS */
@Serializable
data class ClaimsObject(
    /** @see OpenID.Param.Claims.USERINFO */
    @SerialName(OpenID.Param.Claims.USERINFO)
    val userinfo: Map<String, IndividualClaimRequest?> = emptyMap(),

    /** @see OpenID.Param.Claims.ID_TOKEN */
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
