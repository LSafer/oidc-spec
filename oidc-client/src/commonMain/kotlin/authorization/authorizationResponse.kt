package net.lsafer.oidc.client.authorization

import io.ktor.http.*
import net.lsafer.oidc.client.AuthorizationRequest
import net.lsafer.oidc.client.AuthorizationResponse

fun authorizationResponse(
    request: AuthorizationRequest,
    parameters: Parameters,
): AuthorizationResponse {
    val response = AuthorizationResponse(parameters)

    check(request.state == null || request.state == response.state) {
        "Unexpected authorization state"
    }

    return response
}
