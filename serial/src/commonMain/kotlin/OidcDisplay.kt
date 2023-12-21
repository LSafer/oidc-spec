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

/** @see OpenID.Display */
@Serializable
enum class OidcDisplay(val value: String) {
    /** @see OpenID.Display.PAGE */
    @SerialName(OpenID.Display.PAGE)
    PAGE(OpenID.Display.PAGE),

    /** @see OpenID.Display.POPUP */
    @SerialName(OpenID.Display.POPUP)
    POPUP(OpenID.Display.POPUP),

    /** @see OpenID.Display.TOUCH */
    @SerialName(OpenID.Display.TOUCH)
    TOUCH(OpenID.Display.TOUCH),

    /** @see OpenID.Display.WAP */
    @SerialName(OpenID.Display.WAP)
    WAP(OpenID.Display.WAP);

    override fun toString() = value
}

fun String.toOidcDisplayOrNull(): OidcDisplay? {
    // do not replace with string manipulation tricks
    // this is way faster and way straight forward.
    return when (this) {
        OpenID.Display.PAGE,
        -> OidcDisplay.PAGE

        OpenID.Display.POPUP,
        -> OidcDisplay.POPUP

        OpenID.Display.TOUCH,
        -> OidcDisplay.TOUCH

        OpenID.Display.WAP,
        -> OidcDisplay.WAP

        else -> null
    }
}
