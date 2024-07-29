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
package net.lsafer.oidc.client

import kotlinx.serialization.json.JsonObject
import net.lsafer.oidc.client.internal.asBooleanOrNull
import net.lsafer.oidc.client.internal.asInstantFromEpochSeconds
import net.lsafer.oidc.client.internal.asStringListOrNull
import net.lsafer.oidc.client.internal.asStringOrNull
import net.lsafer.oidc.jose.JwtClaim
import kotlin.jvm.JvmInline

@JvmInline
@Suppress("PropertyName")
value class UserinfoObject(val value: JsonObject) {
    private fun boolean(name: String) = value[name]?.asBooleanOrNull
    private fun string(name: String) = value[name]?.asStringOrNull
    private fun stringList(name: String) = value[name]?.asStringListOrNull
    private fun instantEpochSeconds(name: String) = value[name]?.asInstantFromEpochSeconds

    val iss get() = string(JwtClaim.ISS)
    val sub get() = string(JwtClaim.SUB)
    val name get() = string(JwtClaim.NAME)
    val given_name get() = string(JwtClaim.GIVEN_NAME)
    val family_name get() = string(JwtClaim.FAMILY_NAME)
    val middle_name get() = string(JwtClaim.MIDDLE_NAME)
    val nickname get() = string(JwtClaim.NICKNAME)
    val preferred_username get() = string(JwtClaim.PREFERRED_USERNAME)
    val profile get() = string(JwtClaim.PROFILE)
    val picture get() = string(JwtClaim.PICTURE)
    val website get() = string(JwtClaim.WEBSITE)
    val email get() = string(JwtClaim.EMAIL)
    val email_verified get() = boolean(JwtClaim.EMAIL_VERIFIED)
    val gender get() = string(JwtClaim.GENDER)
    val birthdate get() = string(JwtClaim.BIRTHDATE)
    val zoneinfo get() = string(JwtClaim.ZONEINFO)
    val locale get() = string(JwtClaim.LOCALE)
    val phone_number get() = string(JwtClaim.PHONE_NUMBER)
    val phone_number_verified get() = boolean(JwtClaim.PHONE_NUMBER_VERIFIED)
    val updated_at get() = instantEpochSeconds(JwtClaim.UPDATED_AT)
}
