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
package net.lsafer.oidc.oauth

/**
 * OAuth Constants.
 */
object OAuth {
    /**
     * Our chosen base path for oauth. (not part of oauth specification)
     */
    const val PATH = "/oauth2"

    /**
     * OAuth Endpoint Registry
     */
    object Endpoint {
        // https://datatracker.ietf.org/doc/html/rfc6749#section-3.1

        /**
         * Our chosen path for oauth authorization endpoint.
         */
        const val AUTHORIZATION = "$PATH/authorize"

        // https://datatracker.ietf.org/doc/html/rfc6749#section-3.2

        /**
         * Our chosen path for oauth token endpoint.
         */
        const val TOKEN = "$PATH/token"
    }

    /**
     * OAuth Parameters Registry.
     */
    object Param {
        // Custom; added for convenience

        const val TENANT_ID = "tenant_id"

        // https://datatracker.ietf.org/doc/html/rfc6749#section-11.2.2

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

        // https://datatracker.ietf.org/doc/html/rfc6749#section-4.1.2.1

        const val ERROR = "error"

        // https://datatracker.ietf.org/doc/html/rfc6750#section-3

        const val REALM = "realm"

        // https://datatracker.ietf.org/doc/html/rfc7636

        /**
         * REQUIRED. Code challenge.
         */
        const val CODE_CHALLENGE = "code_challenge"

        /**
         * OPTIONAL, defaults to "plain" if not present in the request.
         * Code verifier transformation method is "S256" or "plain".
         */
        const val CODE_CHALLENGE_METHOD = "code_challenge_method"

        /**
         * REQUIRED. Code verifier
         */
        const val CODE_VERIFIER = "code_verifier"

        // https://datatracker.ietf.org/doc/html/rfc8693#section-2.1

        /**
         * OPTIONAL. A URI that indicates the target service or resource where
         * the client intends to use the requested security token.
         */
        const val RESOURCE = "resource"

        /**
         * OPTIONAL. The logical name of the target service where the client intends to
         * use the requested security token.
         */
        const val AUDIENCE = "audience"

        /**
         * OPTIONAL. An identifier for the type of the requested security token.
         * If the requested type is unspecified, the issued token type is at the
         * discretion of the authorization server and may be dictated by knowledge
         * of the requirements of the service or resource indicated by the resource
         * or audience parameter.
         */
        const val REQUESTED_TOKEN_TYPE = "requested_token_type"

        /**
         * REQUIRED. A security token that represents the identity of the party on
         * behalf of whom the request is being made. Typically, the subject of this
         * token will be the subject of the security token issued in response to the
         * request.
         */
        const val SUBJECT_TOKEN = "subject_token"

        /**
         * REQUIRED. An identifier, as described in Section 3, that indicates the
         * type of the security token in the subject_token parameter.
         */
        const val SUBJECT_TOKEN_TYPE = "subject_token_type"

        /**
         * OPTIONAL. A security token that represents the identity of the acting party.
         * Typically, this will be the party that is authorized to use the requested
         * security token and act on behalf of the subject.
         */
        const val ACTOR_TOKEN = "actor_token"

        /**
         * An identifier, as described in Section 3, that indicates the type of the
         * security token in the actor_token parameter. This is REQUIRED when the actor_token
         * parameter is present in the request but MUST NOT be included otherwise.
         */
        const val ACTOR_TOKEN_TYPE = "actor_token_type"

        // https://datatracker.ietf.org/doc/html/rfc8693#section-2.2.1

        /**
         * REQUIRED. An identifier for the representation of the issued security token.
         */
        const val ISSUED_TOKEN_TYPE = "issued_token_type"
    }

    /**
     * OAuth Error Registry.
     */
    object Error {
        // https://datatracker.ietf.org/doc/html/rfc6749

        const val INVALID_REQUEST = "invalid_request"
        const val UNAUTHORIZED_CLIENT = "unauthorized_client"

        /**
         * The resource owner or authorization server denied the request.
         */
        const val ACCESS_DENIED = "access_denied"

        /**
         * The authorization server does not support obtaining an
         * authorization code or access token using this method.
         */
        const val UNSUPPORTED_RESPONSE_TYPE = "unsupported_response_type"

        /**
         * The requested scope is invalid, unknown, malformed, or
         * exceeds the scope granted by the resource owner.
         */
        const val INVALID_SCOPE = "invalid_scope"

        /**
         * The authorization server encountered an unexpected
         * condition that prevented it from fulfilling the request.
         * (This error code is needed because a 500 Internal Server
         * Error HTTP status code cannot be returned to the client
         * via an HTTP redirect.)
         */
        const val SERVER_ERROR = "server_error"

        /**
         * The authorization server is currently unable to handle
         * the request due to a temporary overloading or maintenance
         * of the server.  (This error code is needed because a 503
         * Service Unavailable HTTP status code cannot be returned
         * to the client via an HTTP redirect.)
         */
        const val TEMPORARILY_UNAVAILABLE = "temporarily_unavailable"

        /**
         * Client authentication failed (e.g., unknown client, no
         * client authentication included, or unsupported
         * authentication method).  The authorization server MAY
         * return an HTTP 401 (Unauthorized) status code to indicate
         * which HTTP authentication schemes are supported.  If the
         * client attempted to authenticate via the "Authorization"
         * request header field, the authorization server MUST
         * respond with an HTTP 401 (Unauthorized) status code and
         * include the "WWW-Authenticate" response header field
         * matching the authentication scheme used by the client.
         */
        const val INVALID_CLIENT = "invalid_client"

        /**
         * The provided authorization grant (e.g., authorization
         * code, resource owner credentials) or refresh token is
         * invalid, expired, revoked, does not match the redirection
         * URI used in the authorization request, or was issued to
         * another client.
         */
        const val INVALID_GRANT = "invalid_grant"

        /**
         * The authorization grant type is not supported by the
         * authorization server.
         */
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

        // https://datatracker.ietf.org/doc/html/rfc8693#section-2.2.2

        /**
         * If the authorization server is unwilling or unable to issue a
         * token for any target service indicated by the resource or audience
         * parameters, the invalid_target error code SHOULD be used in the
         * error response.
         */
        const val INVALID_TARGET = "invalid_target"
    }

    /**
     * OAuth values registry for parameter `response_type`
     */
    object ResponseType {
        // https://datatracker.ietf.org/doc/html/rfc6749#section-11.3.2

        const val CODE = "code"
        const val TOKEN = "token"
    }

    /**
     * OAuth values registry for parameter `grant_type`
     */
    object GrantType {
        // https://datatracker.ietf.org/doc/html/rfc6749

        const val AUTHORIZATION_CODE = "authorization_code"
        const val IMPLICIT = "implicit"
        const val CLIENT_CREDENTIALS = "client_credentials"
        const val REFRESH_TOKEN = "refresh_token"
        const val PASSWORD = "password"

        // https://datatracker.ietf.org/doc/html/rfc8693#section-2.1

        const val TOKEN_EXCHANGE = "urn:ietf:params:oauth:grant-type:token-exchange"
    }

    /**
     * OAuth values registry for parameter `token_type`
     */
    object AccessTokenType {
        // https://datatracker.ietf.org/doc/html/rfc6749#section-11.1

        const val BEARER = "bearer"
        const val MAC = "mac"
    }

    /**
     * OAuth values registry for parameter `code_challenge_method`
     */
    object CodeChallengeMethod {
        // https://datatracker.ietf.org/doc/html/rfc7636

        /**
         * code_challenge = code_verifier
         */
        const val PLAIN = "plain"

        /**
         * code_challenge = BASE64URL-ENCODE(SHA256(ASCII(code_verifier)))
         */
        const val S256 = "S256"
    }

    /**
     * In token exchange, this a collection of token type identifiers.
     */
    object TokenType {
        // https://datatracker.ietf.org/doc/html/rfc8693#section-3

        /**
         * Indicates that the token is an OAuth 2.0 access token issued by the given authorization server.
         */
        const val ACCESS_TOKEN = "urn:ietf:params:oauth:token-type:access_token"

        /**
         * Indicates that the token is an OAuth 2.0 refresh token issued by the given authorization server.
         */
        const val REFRESH_TOKEN = "urn:ietf:params:oauth:token-type:refresh_token"

        /**
         * Indicates that the token is an ID Token as defined in Section 2 of [`OpenID.Core`].
         */
        const val ID_TOKEN = "urn:ietf:params:oauth:token-type:id_token"

        /**
         * Indicates that the token is a base64url-encoded SAML 1.1 [OASIS.saml-core-1.1] assertion.
         */
        const val SAML_1 = "urn:ietf:params:oauth:token-type:saml1"

        /**
         * Indicates that the token is a base64url-encoded SAML 2.0 [OASIS.saml-core-2.0-os] assertion.
         */
        const val SAML_2 = "urn:ietf:params:oauth:token-type:saml2"
    }
}
