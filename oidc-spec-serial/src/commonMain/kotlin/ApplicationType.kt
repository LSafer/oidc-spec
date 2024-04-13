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
import net.lsafer.oidc.openid.OpenID

/** @see OpenID.ApplicationType */
@Serializable
enum class ApplicationType(val value: String) {
    /** @see OpenID.ApplicationType.WEB */
    @SerialName(OpenID.ApplicationType.WEB)
    WEB(OpenID.ApplicationType.WEB),

    /** @see OpenID.ApplicationType.NATIVE */
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
