package net.lsafer.oidc.client

import io.ktor.http.*
import kotlinx.serialization.Serializable
import net.lsafer.oidc.oauth.OAuth
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class AuthorizationResponse(val value: Parameters) {
    private fun string(name: String) = value[name]

    val code get() = string(OAuth.Param.CODE)
    val state get() = string(OAuth.Param.STATE)
}
