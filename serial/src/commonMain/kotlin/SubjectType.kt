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

/** @see OpenID.SubjectType */
@Serializable
enum class SubjectType(val value: String) {
    /** @see OpenID.SubjectType.PUBLIC */
    @SerialName(OpenID.SubjectType.PUBLIC)
    PUBLIC(OpenID.SubjectType.PUBLIC),

    /** @see OpenID.SubjectType.PAIRWISE */
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
