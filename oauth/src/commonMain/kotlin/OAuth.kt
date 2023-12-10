package net.lsafer.oidc.oauth

/**
 * [The OAuth 2.0 Authorization Framework](https://datatracker.ietf.org/doc/html/rfc6749)
 */
object OAuth {
    const val PATH = "/oauth2"

    /**
     * [3. Protocol Endpoints](https://datatracker.ietf.org/doc/html/rfc6749#section-3)
     */
    object Endpoint {
        /**
         * [3.1. Authorization Endpoint](https://datatracker.ietf.org/doc/html/rfc6749#section-3.1)
         */
        const val AUTHORIZATION = "$PATH/authorize"

        /**
         * [3.2. Token Endpoint](https://datatracker.ietf.org/doc/html/rfc6749#section-3.2)
         */
        const val TOKEN = "$PATH/token"
    }

    /**
     * [11.2. OAuth Parameters Registry](https://datatracker.ietf.org/doc/html/rfc6749#section-11.2)
     */
    object Param {
        const val CLIENT_ID = "client_id"
        const val CLIENT_SECRET = "client_secret"
        const val RESPONSE_TYPE = "response_type"
        const val REDIRECT_URI = "redirect_uri"
        const val SCOPE = "scope"
        const val STATE = "state"
        const val CODE = "code"
        const val ERROR_DESCRIPTION = "error_description"
        const val ERROR_URI = "error_uri"
        const val GRANT_TYPE = "grant_type"
        const val ACCESS_TOKEN = "access_token"
        const val TOKEN_TYPE = "token_type"
        const val EXPIRES_IN = "expires_in"
        const val USERNAME = "username"
        const val PASSWORD = "password"
        const val REFRESH_TOKEN = "refresh_token"

        const val ERROR = "error"

        // EXTENSIONS

        /**
         * OPTIONAL. The tenant the authorization is for.
         *
         * Specifying this will bound resulting access tokens to a specific
         * tenant and require the user to consent to that tenant.
         *
         * If omitted, the resulting access tokens won't be bound to any tenant
         * and the user will be consented to the client only.
         *
         * If client is not allowed multi-tenancy. The error `unauthorized_client` will be returned.
         */
        const val TENANT_ID = "tenant_id"
    }

    object Error {
        const val INVALID_REQUEST = "invalid_request"
        const val UNAUTHORIZED_CLIENT = "unauthorized_client"
        const val ACCESS_DENIED = "access_denied"
        const val UNSUPPORTED_RESPONSE_TYPE = "unsupported_response_type"
        const val INVALID_SCOPE = "invalid_scope"
        const val SERVER_ERROR = "server_error"
        const val TEMPORARILY_UNAVAILABLE = "temporarily_unavailable"

        const val INVALID_CLIENT = "invalid_client"
        const val INVALID_GRANT = "invalid_grant"
        const val UNSUPPORTED_GRANT_TYPE = "unsupported_grant_type"

        // https://datatracker.ietf.org/doc/html/rfc6750#section-3.1

        /**
         * The access token provided is expired, revoked, malformed, or
         * invalid for other reasons.  The resource SHOULD respond with
         * the HTTP 401 (Unauthorized) status code.  The client MAY
         * request a new access token and retry the protected resource
         * request.
         */
        const val INVALID_TOKEN = "invalid_token"

        /**
         * The request requires higher privileges than provided by the
         * access token.  The resource server SHOULD respond with the HTTP
         * 403 (Forbidden) status code and MAY include the "scope"
         * attribute with the scope necessary to access the protected
         * resource.
         */
        const val INSUFFICIENT_SCOPE = "insufficient_scope"
    }

    //

    object ResponseType {
        // https://datatracker.ietf.org/doc/html/rfc6749#section-11.3

        /** [4.1. Authorization Code Grant](https://datatracker.ietf.org/doc/html/rfc6749#section-4.1) */
        const val CODE = "code"

        /** [4.2. Implicit Grant](https://datatracker.ietf.org/doc/html/rfc6749#section-4.2) */
        const val TOKEN = "token"
    }

    object GrantType {
        const val AUTHORIZATION_CODE = "authorization_code"
        const val IMPLICIT = "implicit"
        const val CLIENT_CREDENTIALS = "client_credentials"
        const val REFRESH_TOKEN = "refresh_token"
        const val PASSWORD = "password"
    }

    /**
     * [7.1. Access Token Types](https://datatracker.ietf.org/doc/html/rfc6749#section-7.1)
     * [11.1. OAuth Access Token Types Registry](https://datatracker.ietf.org/doc/html/rfc6749#section-11.1)
     */
    object AccessTokenType {
        const val BEARER = "bearer"
        const val MAC = "mac"
    }
}
