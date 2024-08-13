package net.lsafer.oidc.client.authorization

import io.ktor.http.*
import net.lsafer.oidc.client.AuthorizationRequest
import net.lsafer.oidc.client.AuthorizationResponse

/**
 * @param authorizationRequest authorization request parameters.
 * @param parameters response returned by authorization server.
 */
fun authorizationResponse(
    authorizationRequest: AuthorizationRequest,
    parameters: Parameters,
): AuthorizationResponse {
    val response = AuthorizationResponse(parameters)

    check(authorizationRequest.state == null || authorizationRequest.state == response.state) {
        "Unexpected authorization state"
    }

    return response
}
