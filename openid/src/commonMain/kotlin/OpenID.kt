package net.lsafer.oidc.openid

object OpenID {
    const val PATH = "/openid"

    object Endpoint {
        const val JWKS = "/.well-known/jwks.json"
        const val OPENID_CONFIGURATION = "/.well-known/openid-configuration"

        const val USERINFO = "$PATH/userinfo"
        const val REGISTRATION = "$PATH/registration"
        const val CLIENT_CONFIGURATION = "$PATH/client-configuration"
    }

    object Param {
        // Extension

        /**
         * OPTIONAL. This parameter enables clients to be pass tenant information in a jwt that is
         * optionally signed and/or encrypted.
         */
        const val TENANT = "tenant"

        /**
         * OPTIONAL. This parameter enables OpenID Connect tenant objects to be passed by reference, rather than by value.
         * The tenant_uri value is a URL using the https scheme referencing a resource containing a Tenant Object
         * value, which is a JWT containing the tenant data.
         */
        const val TENANT_URI = "tenant_uri"

        // https://www.authlete.com/developers/definitive_guide/authorization_endpoint_spec/
        // https://openid.net/specs/openid-connect-core-1_0.html#AuthRequest

        /**
         * OPTIONAL. Informs the Authorization Server of the mechanism to be used for returning Authorization Response
         * parameters from the Authorization Endpoint.
         * This use of this parameter is NOT RECOMMENDED with a value that specifies the same Response Mode as the
         * default Response Mode for the Response Type used.
         *
         * [OIDC Responses # 2.1 Response Modes](https://openid.net/specs/oauth-v2-multiple-response-types-1_0.html)
         * [OIDC CORE # 3.1.2.1. Authentication Request](https://openid.net/specs/openid-connect-core-1_0.html#AuthRequest)
         */
        const val RESPONSE_MODE = "response_mode"

        /**
         * OPTIONAL. String value used to associate a Client session with an ID Token, and to mitigate replay attacks.
         * The value is passed through unmodified from the Authentication Request to the ID Token.
         * Sufficient entropy MUST be present in the nonce values used to prevent attackers from guessing values.
         * For implementation notes, see [Section 15.5.2](https://openid.net/specs/openid-connect-core-1_0.html#NonceNotes).
         *
         * [OIDC CORE # 3.1.2.1. Authentication Request](https://openid.net/specs/openid-connect-core-1_0.html#AuthRequest)
         */
        const val NONCE = "nonce"

        /**
         * OPTIONAL. ASCII string value that specifies how the Authorization Server displays the authentication and
         * consent user interface pages to the End-User.
         *
         * [OIDC CORE # 3.1.2.1. Authentication Request](https://openid.net/specs/openid-connect-core-1_0.html#AuthRequest)
         */
        const val DISPLAY = "display"

        /**
         * OPTIONAL. Space delimited, case-sensitive list of ASCII string values that specifies whether the
         * Authorization Server prompts the End-User for reauthentication and consent.
         */
        const val PROMPT = "prompt"

        /**
         * OPTIONAL. Maximum Authentication Age. Specifies the allowable elapsed time in seconds since the last time the
         * End-User was actively authenticated by the OP.
         *
         * If the elapsed time is greater than this value, the OP MUST attempt to actively re-authenticate the End-User.
         * (The max_age request parameter corresponds to the OpenID 2.0 PAPE max_auth_age request parameter.)
         * When max_age is used, the ID Token returned MUST include an auth_time Claim Value.
         *
         * [OIDC CORE # 3.1.2.1. Authentication Request](https://openid.net/specs/openid-connect-core-1_0.html#AuthRequest)
         */
        const val MAX_AGE = "max_age"

        /**
         * OPTIONAL. End-User's preferred languages and scripts for the user interface, represented as a space-separated
         * list of BCP47 `RFC5646` language tag values, ordered by preference.
         *
         * For instance, the value "fr-CA fr en" represents a preference for French as spoken in Canada, then French
         * (without a region designation), followed by English (without a region designation).
         *
         * An error SHOULD NOT result if some or all of the requested locales are not supported by the OpenID Provider.
         */
        const val UI_LOCALES = "ui_locales"

        /**
         * OPTIONAL. ID Token previously issued by the Authorization Server being passed as a hint about the End-User's
         * current or past authenticated session with the Client.
         *
         * If the End-User identified by the ID Token is logged in or is logged in by the request, then the
         * Authorization Server returns a positive response;
         * otherwise, it SHOULD return an error, such as login_required. When possible, an id_token_hint SHOULD be
         * present when prompt=none is used and an invalid_request error MAY be returned if it is not;
         * however, the server SHOULD respond successfully when possible, even if it is not present.
         * The Authorization Server need not be listed as an audience of the ID Token when it is used as an
         * id_token_hint value.
         * If the ID Token received by the RP from the OP is encrypted, to use it as an id_token_hint, the Client MUST
         * decrypt the signed ID Token contained within the encrypted ID Token. The Client MAY re-encrypt the signed ID
         * token to the Authentication Server using a key that enables the server to decrypt the ID Token, and use the
         * re-encrypted ID token as the id_token_hint value.
         */
        const val ID_TOKEN_HINT = "id_token_hint"

        /**
         * OPTIONAL. Hint to the Authorization Server about the login identifier the End-User might use to log in (if
         * necessary). This hint can be used by an RP if it first asks the End-User for their e-mail address (or other
         * identifier) and then wants to pass that value as a hint to the discovered authorization service.
         * It is RECOMMENDED that the hint value match the value used for discovery.
         * This value MAY also be a phone number in the format specified for the phone_number Claim.
         * The use of this parameter is left to the OP's discretion.
         */
        const val LOGIN_HINT = "login_hint"

        /**
         * OPTIONAL. Requested Authentication Context Class Reference values. Space-separated string that specifies the
         * acr values that the Authorization Server is being requested to use for processing this Authentication Request,
         * with the values appearing in order of preference.
         *
         * The Authentication Context Class satisfied by the authentication performed is returned as the acr Claim Value,
         * as specified in Section 2. The acr Claim is requested as a Voluntary Claim by this parameter.
         */
        const val ACR_VALUES = "acr_values"

        // https://openid.net/specs/openid-connect-core-1_0.html#TokenResponse

        /**
         * ID Token value associated with the authenticated session.
         *
         * [OIDC CORE 1.0 # 3.1.3.3. Successful Token Response](https://openid.net/specs/openid-connect-core-1_0.html#TokenResponse)
         */
        const val ID_TOKEN = "id_token"

        // https://openid.net/specs/openid-connect-core-1_0.html#JWTRequests

        /**
         * OPTIONAL. This parameter enables OpenID Connect requests to be passed in a single, self-contained parameter
         * and to be optionally signed and/or encrypted. The parameter value is a Request Object value,
         * as specified in [Section 6.1](https://openid.net/specs/openid-connect-core-1_0.html#RequestObject).
         * It represents the request as a JWT whose Claims are the request parameters.
         *
         * [OIDC CORE 1.0 # 6. Passing Request Parameters as JWTs](https://openid.net/specs/openid-connect-core-1_0.html#JWTRequests)
         */
        const val REQUEST = "request"

        /**
         * OPTIONAL. This parameter enables OpenID Connect requests to be passed by reference, rather than by value.
         * The request_uri value is a URL using the https scheme referencing a resource containing a Request Object
         * value, which is a JWT containing the request parameters.
         *
         * [OIDC CORE 1.0 # 6. Passing Request Parameters as JWTs](https://openid.net/specs/openid-connect-core-1_0.html#JWTRequests)
         */
        const val REQUEST_URI = "request_uri"

        // https://openid.net/specs/openid-connect-core-1_0.html#ClaimsLanguagesAndScripts

        /**
         * OPTIONAL. End-User's preferred languages and scripts for Claims being returned, represented as a
         * space-separated list of BCP47 `RFC5646` language tag values, ordered by preference.
         *
         * An error SHOULD NOT result if some or all of the requested locales are not supported by the OpenID Provider.
         *
         * [OIDC CORE 1.0 # 5.2. Claims Languages and Scripts](https://openid.net/specs/openid-connect-core-1_0.html#ClaimsLanguagesAndScripts)
         */
        const val CLAIMS_LOCALES = "claims_locales"

        // https://openid.net/specs/openid-connect-core-1_0.html#ClaimsParameter

        /**
         * OPTIONAL. This parameter is used to request that specific Claims be returned.
         *
         * The value is a JSON object listing the requested Claims.
         */
        const val CLAIMS = "claims"

        /**
         * The members of the [CLAIMS] claim.
         */
        object Claims {
            /**
             * OPTIONAL. Requests that the listed individual Claims be returned from the UserInfo Endpoint.
             * If present, the listed Claims are being requested to be added to any Claims that are being requested using
             * scope values.
             * If not present, the Claims being requested from the UserInfo Endpoint are only those requested using scope
             * values.
             * When the userinfo member is used, the request MUST also use a response_type value that results in an Access
             * Token being issued to the Client for use at the UserInfo Endpoint.
             */
            const val USERINFO = "userinfo"

            /**
             * OPTIONAL. Requests that the listed individual Claims be returned in the ID Token.
             * If present, the listed Claims are being requested to be added to the default Claims in the ID Token.
             * If not present, the default ID Token Claims are requested, as per the ID Token definition in Section 2 and
             * per the additional per-flow ID Token requirements in Sections 3.1.3.6, 3.2.2.10, 3.3.2.11, and 3.3.3.6.
             */
            const val ID_TOKEN = "id_token"

            /**
             * OPTIONAL. Indicates whether the Claim being requested is an Essential Claim. If the value is true, this
             * indicates that the Claim is an Essential Claim.
             */
            const val ESSENTIAL = "essential"

            /**
             * OPTIONAL. Requests that the Claim be returned with a particular value.
             */
            const val VALUE = "value"

            /**
             * OPTIONAL. Requests that the Claim be returned with one of a set of values, with the values appearing in
             * order of preference.
             */
            const val VALUES = "values"
        }

        // https://openid.net/specs/openid-connect-registration-1_0.html#RegistrationResponse

        /**
         * OPTIONAL. Registration Access Token that can be used at the Client Configuration Endpoint to perform
         * subsequent operations upon the Client registration.
         */
        const val REGISTRATION_ACCESS_TOKEN = "registration_access_token"

        /**
         * OPTIONAL. Location of the Client Configuration Endpoint where the Registration Access Token can be used to
         * perform subsequent operations upon the resulting Client registration. Implementations MUST either return both
         * a Client Configuration Endpoint and a Registration Access Token or neither of them.
         */
        const val REGISTRATION_CLIENT_URI = "registration_client_uri"

        /**
         * OPTIONAL. Time at which the Client Identifier was issued. Its value is a JSON number representing the number
         * of seconds from 1970-01-01T0:0:0Z as measured in UTC until the date/time.
         */
        const val CLIENT_ID_ISSUED_AT = "client_id_issued_at"

        /**
         * REQUIRED if client_secret is issued. Time at which the client_secret will expire or 0 if it will not expire.
         * Its value is a JSON number representing the number of seconds from 1970-01-01T0:0:0Z as measured in UTC until
         * the date/time.
         */
        const val CLIENT_SECRET_EXPIRES_AT = "client_secret_expires_at"
    }

    object Error {
        // 3.1.2.6. Authentication Error Response https://openid.net/specs/openid-connect-core-1_0.html#AuthError

        /**
         * The Authorization Server requires End-User interaction of some form to proceed.
         * This error MAY be returned when the prompt parameter value in the Authentication Request is none, but the
         * Authentication Request cannot be completed without displaying a user interface for End-User interaction.
         */
        const val INTERACTION_REQUIRED = "interaction_required"

        /**
         * The Authorization Server requires End-User authentication. This error MAY be returned when the prompt
         * parameter value in the Authentication Request is none, but the Authentication Request cannot be completed
         * without displaying a user interface for End-User authentication.
         */
        const val LOGIN_REQUIRED = "login_required"

        /**
         * The End-User is REQUIRED to select a session at the Authorization Server.
         * The End-User MAY be authenticated at the Authorization Server with different associated accounts, but the
         * End-User did not select a session.
         * This error MAY be returned when the prompt parameter value in the Authentication Request is none, but the
         * Authentication Request cannot be completed without displaying a user interface to prompt for a session to use.
         */
        const val ACCOUNT_SELECTION_REQUIRED = "account_selection_required"

        /**
         * The Authorization Server requires End-User consent.
         * This error MAY be returned when the prompt parameter value in the Authentication Request is none,
         * but the Authentication Request cannot be completed without displaying a user interface for End-User consent.
         */
        const val CONSENT_REQUIRED = "consent_required"

        /**
         * The request_uri in the Authorization Request returns an error or contains invalid data.
         */
        const val INVALID_REQUEST_URI = "invalid_request_uri"

        /**
         * The request parameter contains an invalid Request Object.
         */
        const val INVALID_REQUEST_OBJECT = "invalid_request_object"

        /**
         * The OP does not support use of the request parameter defined in Section 6.
         */
        const val REQUEST_NOT_SUPPORTED = "request_not_supported"

        /**
         * The OP does not support use of the request_uri parameter defined in Section 6.
         */
        const val REQUEST_URI_NOT_SUPPORTED = "request_uri_not_supported"

        /**
         * The OP does not support use of the registration parameter
         * defined in [Section 7.2.1](https://openid.net/specs/openid-connect-core-1_0.html#RegistrationParameter).
         */
        const val REGISTRATION_NOT_SUPPORTED = "registration_not_supported"

        // https://openid.net/specs/openid-connect-registration-1_0.html#RegistrationError

        /**
         * The value of one or more redirect_uris is invalid.
         */
        const val INVALID_REDIRECT_URI = "invalid_redirect_uri"

        /**
         * The value of one of the Client Metadata fields is invalid and the server has rejected this request.
         *
         * Note that an Authorization Server MAY choose to substitute a valid value for any requested parameter of a
         * Client's Metadata.
         */
        const val INVALID_CLIENT_METADATA = "invalid_client_metadata"

        // https://openid.net/specs/openid-connect-unmet-authentication-requirements-1_0.html

        /**
         * The Authorization Server is unable to meet the requirements of the Relying Party for the authentication
         * of the End-User. This error code SHALL be used if the Relying Party wants the OP to conform to a certain
         * Authentication Context Class Reference value using an essential claim acr claim as specified in
         * Section 5.5.1.1. of OpenID Connect Core [`OpenID.Core`] and the OP is unable to meet this requirement
         * and MAY be used in other cases, if appropriate.
         */
        const val UNMET_AUTHENTICATION_REQUIREMENTS = "unmet_authentication_requirements"
    }

    object Scope {
        const val OPENID = "openid"

        // https://openid.net/specs/openid-connect-core-1_0.html#ScopeClaims

        /**
         * This scope value requests access to the End-User's default profile Claims, which are:
         *
         * - `name`
         * - `family_name`
         * - `given_name`
         * - `middle_name`
         * - `nickname`
         * - `preferred_username`
         * - `profile`
         * - `picture`
         * - `website`
         * - `gender`
         * - `birthdate`
         * - `zoneinfo`
         * - `locale`
         * - `updated_at`
         *
         * [OIDC CORE 1.0 # 5.4 Requesting Claims using Scope Values](https://openid.net/specs/openid-connect-core-1_0.html#ScopeClaims)
         */
        const val PROFILE = "profile"

        /**
         * This scope value requests access to the following claims:
         *
         * - `email`
         * - `email_verified`
         *
         * [OIDC CORE 1.0 # 5.4 Requesting Claims using Scope Values](https://openid.net/specs/openid-connect-core-1_0.html#ScopeClaims)
         */
        const val EMAIL = "email"

        /**
         * This scope value requests access to the following claims:
         *
         * - `address`
         *
         * [OIDC CORE 1.0 # 5.4 Requesting Claims using Scope Values](https://openid.net/specs/openid-connect-core-1_0.html#ScopeClaims)
         */
        const val ADDRESS = "address"

        /**
         * This scope value requests access to the following claims:
         *
         * - `phone_number`
         * - `phone_number_verified`
         *
         * [OIDC CORE 1.0 # 5.4 Requesting Claims using Scope Values](https://openid.net/specs/openid-connect-core-1_0.html#ScopeClaims)
         */
        const val PHONE = "phone"

        // https://openid.net/specs/openid-connect-core-1_0.html#OfflineAccess

        /**
         * This scope value requests that an OAuth 2.0 Refresh Token be issued that can be used to obtain an Access Token
         * that grants access to the End-User's UserInfo Endpoint even when the End-User is not present (not logged in).
         *
         * > In a nutshell, this allows for obtaining refresh tokens.
         *
         * [OIDC CORE 1.0 # 11 Offline Access](https://openid.net/specs/openid-connect-core-1_0.html#OfflineAccess)
         */
        const val OFFLINE_ACCESS = "offline_access"
    }

    object ResponseType {
        // https://openid.net/specs/oauth-v2-multiple-response-types-1_0.html#RegistryContents

        /**
         * When supplied as the `response_type` parameter in an OAuth 2.0 Authorization Request, the Authorization
         * Server SHOULD NOT return an OAuth 2.0 Authorization Code, Access Token, Access Token Type, or ID Token in a
         * successful response to the grant request. If a `redirect_uri` is supplied, the User Agent SHOULD be
         * redirected there after granting or denying access. The request MAY include a state parameter, and if so,
         * the Authorization Server MUST echo its value as a response parameter when issuing either a successful
         * response or an error response. The default Response Mode for this Response Type is the
         * [query][ResponseMode.QUERY] encoding.
         * Both successful and error responses SHOULD be returned using the supplied Response Mode, or if none is
         * supplied, using the default Response Mode.
         *
         * [OIDC Responses # 4 None Response Type](https://openid.net/specs/oauth-v2-multiple-response-types-1_0.html#none)
         */
        const val NONE = "none"

        /**
         * When supplied as the `response_type` parameter in an OAuth 2.0 Authorization Request, a successful response
         * MUST include the parameter [id_token][Param.ID_TOKEN].
         * The Authorization Server SHOULD NOT return an OAuth 2.0 Authorization Code, Access Token, or Access Token
         * Type in a successful response to the grant request.
         * If a `redirect_uri` is supplied, the User Agent SHOULD be redirected there after granting or denying access.
         * The request MAY include a state parameter, and if so, the Authorization Server MUST echo its value as a
         * response parameter when issuing either a successful response or an error response.
         * The default Response Mode for this Response Type is the [fragment][ResponseMode.FRAGMENT] encoding and the
         * query encoding MUST NOT be used.
         * Both successful and error responses SHOULD be returned using the supplied Response Mode, or if none is
         * supplied, using the default Response Mode.
         *
         * [OIDC Responses # 3 ID Token Response Type](https://openid.net/specs/oauth-v2-multiple-response-types-1_0.html#id_token)
         */
        const val ID_TOKEN = "id_token"

        /**
         * When supplied as the value for the `response_type` parameter, a successful response MUST include an Access
         * Token, an Access Token Type, and an id_token. The default Response Mode for this Response Type is the
         * [fragment][ResponseMode.FRAGMENT] encoding and the query encoding MUST NOT be used.
         * Both successful and error responses SHOULD be returned using the supplied Response Mode, or if none is
         * supplied, using the default Response Mode.
         *
         * [OIDC Responses # 5 Definitions of Multiple-Valued Response Type Combinations](https://openid.net/specs/oauth-v2-multiple-response-types-1_0.html#Combinations)
         */
        const val ID_TOKEN_TOKEN = "id_token token"

        /**
         * When supplied as the value for the `response_type` parameter, a successful response MUST include an
         * Access Token, an Access Token Type, and an Authorization Code.
         * The default Response Mode for this Response Type is the [fragment][ResponseMode.FRAGMENT] encoding and the
         * query encoding MUST NOT be used.
         * Both successful and error responses SHOULD be returned using the supplied Response Mode, or if none is
         * supplied, using the default Response Mode.
         *
         * [OIDC Responses # 5 Definitions of Multiple-Valued Response Type Combinations](https://openid.net/specs/oauth-v2-multiple-response-types-1_0.html#Combinations)
         */
        const val CODE_TOKEN = "code token"

        /**
         * When supplied as the value for the `response_type` parameter, a successful response MUST include both an
         * Authorization Code and an id_token. The default Response Mode for this Response Type is the
         * [fragment][ResponseMode.FRAGMENT] encoding and the query encoding MUST NOT be used.
         * Both successful and error responses SHOULD be returned using the supplied Response Mode, or if none is
         * supplied, using the default Response Mode.
         *
         * [OIDC Responses # 5 Definitions of Multiple-Valued Response Type Combinations](https://openid.net/specs/oauth-v2-multiple-response-types-1_0.html#Combinations)
         */
        const val CODE_ID_TOKEN = "code id_token"

        /**
         * When supplied as the value for the response_type parameter, a successful response MUST include an
         * Authorization Code, an id_token, an Access Token, and an Access Token Type. The default Response Mode for
         * this Response Type is the [fragment][ResponseMode.FRAGMENT] encoding and the query encoding MUST NOT be used.
         * Both successful and error responses SHOULD be returned using the supplied Response Mode,
         * or if none is supplied, using the default Response Mode.
         *
         * [OIDC Responses # 5 Definitions of Multiple-Valued Response Type Combinations](https://openid.net/specs/oauth-v2-multiple-response-types-1_0.html#Combinations)
         */
        const val CODE_ID_TOKEN_TOKEN = "code id_token token"
    }

    object ResponseMode {
        // https://openid.net/specs/oauth-v2-multiple-response-types-1_0.html

        /**
         * In this mode, Authorization Response parameters are encoded in the query string added to the redirect_uri
         * when redirecting back to the Client.
         *
         * [OIDC Responses # 2.1 Response Modes](https://openid.net/specs/oauth-v2-multiple-response-types-1_0.html)
         */
        const val QUERY = "query"

        /**
         * In this mode, Authorization Response parameters are encoded in the fragment added to the redirect_uri when
         * redirecting back to the Client.
         *
         * [OIDC Responses # 2.1 Response Modes](https://openid.net/specs/oauth-v2-multiple-response-types-1_0.html)
         */
        const val FRAGMENT = "fragment"
    }

    object Display {
        // https://openid.net/specs/openid-connect-core-1_0.html#AuthRequest

        /**
         * The Authorization Server SHOULD display the authentication and consent UI consistent with a full User Agent page view.
         *
         * If the display parameter is not specified, this is the default display mode.
         */
        const val PAGE = "page"

        /**
         * The Authorization Server SHOULD display the authentication and consent UI consistent with a popup User Agent window.
         *
         * The popup User Agent window should be of an appropriate size for a login-focused dialog and should not
         * obscure the entire window that it is popping up over.
         */
        const val POPUP = "popup"

        /**
         * The Authorization Server SHOULD display the authentication and consent UI consistent with a device that
         * leverages a touch interface.
         */
        const val TOUCH = "touch"

        /**
         * The Authorization Server SHOULD display the authentication and consent UI consistent with a "feature phone" type display.
         */
        const val WAP = "wap"
    }

    object Prompt {
        // https://openid.net/specs/openid-connect-core-1_0.html#AuthRequest

        /**
         * The Authorization Server MUST NOT display any authentication or consent user interface pages.
         * An error is returned if an End-User is not already authenticated or the Client does not have pre-configured
         * consent for the requested Claims or does not fulfill other conditions for processing the request.
         * The error code will typically be `login_required`, `interaction_required`, or another code
         * defined in [Section 3.1.2.6](https://openid.net/specs/openid-connect-core-1_0.html#AuthError)
         * This can be used as a method to check for existing authentication and/or consent.
         *
         * [OIDC CORE 1.0 # 3.1.2.1 Authentication Request][https://openid.net/specs/openid-connect-core-1_0.html#AuthRequest]
         */
        const val NONE = "none"

        /**
         * The Authorization Server SHOULD prompt the End-User for reauthentication. If it cannot reauthenticate the
         * End-User, it MUST return an error, typically `login_required`.
         *
         * [OIDC CORE 1.0 # 3.1.2.1 Authentication Request][https://openid.net/specs/openid-connect-core-1_0.html#AuthRequest]
         */
        const val LOGIN = "login"

        /**
         * The Authorization Server SHOULD prompt the End-User for consent before returning information to the Client.
         * If it cannot obtain consent, it MUST return an error, typically `consent_required`.
         *
         * [OIDC CORE 1.0 # 3.1.2.1 Authentication Request][https://openid.net/specs/openid-connect-core-1_0.html#AuthRequest]
         */
        const val CONSENT = "consent"

        /**
         * The Authorization Server SHOULD prompt the End-User to select a user account.
         * This enables an End-User who has multiple accounts at the Authorization Server to select amongst the multiple
         * accounts that they might have current sessions for.
         * If it cannot obtain an account selection choice made by the End-User, it MUST return an error, typically
         * `account_selection_required`.
         *
         * [OIDC CORE 1.0 # 3.1.2.1 Authentication Request][https://openid.net/specs/openid-connect-core-1_0.html#AuthRequest]
         */
        const val SELECT_ACCOUNT = "select_account"

        // https://openid.net/specs/openid-connect-prompt-create-1_0.html

        /**
         * [OIDC Prompt Create 1.0][https://openid.net/specs/openid-connect-prompt-create-1_0.html]
         */
        const val CREATE = "create"
    }

    object ACR {
        const val ZERO = "0"
    }

    object AMR {
        // Extensions

        /**
         * Time-based one-time password
         */
        const val TOTP = "totp"

        // https://datatracker.ietf.org/doc/html/draft-ietf-oauth-amr-values-04#section-2

        /**
         * Facial recognition
         */
        const val FACE = "face"

        /**
         * Fingerprint biometric
         */
        const val FPT = "fpt"

        /**
         * Use of geolocation information
         */
        const val GEO = "geo"

        /**
         * Proof-of-possession (PoP) of a hardware-secured key.
         *
         * See Appendix C of `RFC4211` for a discussion on PoP.
         */
        const val HWK = "hwk"

        /**
         * Iris scan biometric
         */
        const val IRIS = "iris"

        /**
         * Knowledge-based authentication [NIST.800-63-2] `ISO29115`
         */
        const val KBA = "kba"

        /**
         * Multiple-channel authentication.  The authentication involves
         * communication over more than one distinct communication channel.
         * For instance, a multiple-channel authentication might involve both
         * entering information into a workstation's browser and providing
         * information on a telephone call to a pre-registered number.
         */
        const val MCA = "mca"

        /**
         * Multiple-factor authentication [NIST.800-63-2] `ISO29115`.  When
         * this is present, specific authentication methods used may also be
         * included.
         */
        const val MFA = "mfa"

        /**
         * One-time password.  One-time password specifications that this
         * authentication method applies to include `RFC4226` and `RFC6238`.
         */
        const val OTP = "otp"

        /**
         * Personal Identification Number or pattern (not restricted to
         * containing only numbers) that a user enters to unlock a key on the
         * device.  This mechanism should have a way to deter an attacker
         * from obtaining the PIN by trying repeated guesses.
         */
        const val PIN = "pin"

        /**
         * Password-based authentication
         */
        const val PWD = "pwd"

        /**
         * Risk-based authentication `JECM`
         */
        const val RBA = "rba"

        /**
         * Retina scan biometric
         */
        const val RETINA = "retina"

        /**
         * Smart card
         */
        const val SC = "sc"

        /**
         * Confirmation using SMS message to the user at a registered number
         */
        const val SMS = "sms"

        /**
         * Proof-of-possession (PoP) of a software-secured key.
         *
         * See Appendix C of `RFC4211` for a discussion on PoP.
         */
        const val SWK = "swk"

        /**
         * Confirmation by telephone call to the user at a registered number
         */
        const val TEL = "tel"

        /**
         * User presence test
         */
        const val USER = "user"

        /**
         * Voice biometric
         */
        const val VBM = "vbm"

        /**
         * Windows integrated authentication, as described in `MSDN`
         */
        const val WIA = "wia"
    }

    object SubjectType {
        // https://openid.net/specs/openid-connect-core-1_0.html#SubjectIDTypes

        /**
         * This provides the same `sub` (subject) value to all Clients.
         *
         * It is the default if the provider has no `subject_types_supported` element in its discovery document.
         */
        const val PUBLIC = "public"

        /**
         * This provides a different `sub` value to each Client, so as not to enable Clients to correlate the End-User's
         * activities without permission.
         */
        const val PAIRWISE = "pairwise"
    }

    object ClientAuthentication {
        // https://openid.net/specs/openid-connect-core-1_0.html#ClientAuthentication

        const val NONE = "none"
        const val CLIENT_SECRET_BASIC = "client_secret_basic"
        const val CLIENT_SECRET_POST = "client_secret_post"
        const val CLIENT_SECRET_JWT = "client_secret_jwt"
        const val PRIVATE_KEY_JWT = "private_key_jwt"
    }

    object ClaimType {
        /**
         * Claims that are directly asserted by the OpenID Provider.
         */
        const val NORMAL = "normal"

        /**
         * Claims that are asserted by a Claims Provider other than the OpenID Provider but are returned by OpenID Provider.
         */
        const val AGGREGATED = "aggregated"

        /**
         * Claims that are asserted by a Claims Provider other than the OpenID Provider but are returned as references by the OpenID Provider.
         */
        const val DISTRIBUTED = "distributed"
    }

    object ApplicationType {
        // https://openid.net/specs/openid-connect-registration-1_0.html#ClientMetadata

        const val WEB = "web"
        const val NATIVE = "native"
    }
}
