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

import kotlinx.serialization.Serializable
import net.lsafer.oidc.openid.OpenID
import kotlin.jvm.JvmInline

/** @see OpenID.Scope */
@JvmInline
@Serializable
value class OidcScope(val value: String) {
    companion object {
        /** @see OpenID.Scope.OPENID */
        val OPENID = OidcScope(OpenID.Scope.OPENID)

        /** @see OpenID.Scope.PROFILE */
        val PROFILE = OidcScope(OpenID.Scope.PROFILE)

        /** @see OpenID.Scope.EMAIL */
        val EMAIL = OidcScope(OpenID.Scope.EMAIL)

        /** @see OpenID.Scope.ADDRESS */
        val ADDRESS = OidcScope(OpenID.Scope.ADDRESS)

        /** @see OpenID.Scope.PHONE */
        val PHONE = OidcScope(OpenID.Scope.PHONE)

        /** @see OpenID.Scope.OFFLINE_ACCESS */
        val OFFLINE_ACCESS = OidcScope(OpenID.Scope.OFFLINE_ACCESS)
    }

    override fun toString() = value
}

fun String.toOidcScopeSequence(): Sequence<OidcScope> {
    if (isBlank()) return emptySequence()
    return splitToSequence(" ")
        .map { it.asOidcScope() }
}

fun String.asOidcScope(): OidcScope {
    return OidcScope(this)
}
