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
package net.lsafer.oidc.jose

/**
 * Jwt Claim Names Registry
 */
object JwtClaim {
    // Custom; added for convenience

    const val SOFTWARE_ID = "software_id"

    /**
     * True if the Subject has been manually verified (deserves verification badge)
     */
    const val VERIFIED = "verified"

    /**
     * True if the Subject is declared to be suspended (banned).
     */
    const val SUSPENDED = "suspended"

    /**
     * OPTIONAL. The id of the tenant the token is bound to.
     *
     * If omitted, the access token acts as a general access token with
     * no access to tenant-specific data.
     */
    const val TENANT_ID = "tenant_id"

    /**
     * OPTIONAL. confidential session variables interpreted by domain.
     */
    const val SESSION = "session"

    /**
     * Other additional address of the user.
     */
    const val ADDITIONAL_ADDRESSES = "additional_addresses"

    // https://www.iana.org/assignments/jwt/jwt.xhtml

    /**
     * **string**
     * Issuer
     *
     * [RFC7519, Section 4.1.1](https://www.rfc-editor.org/rfc/rfc7519.html#section-4.1.1)
     */
    const val ISS = "iss"

    /**
     * **string**
     * Subject
     *
     * [RFC7519, Section 4.1.2](https://www.rfc-editor.org/rfc/rfc7519.html#section-4.1.2)
     */
    const val SUB = "sub"

    /**
     * **string[]**
     * Audience
     *
     * [RFC7519, Section 4.1.3](https://www.rfc-editor.org/rfc/rfc7519.html#section-4.1.3)
     */
    const val AUD = "aud"

    /**
     * **epoch-seconds**
     * Expiration Time
     *
     * [RFC7519, Section 4.1.4](https://www.rfc-editor.org/rfc/rfc7519.html#section-4.1.4)
     */
    const val EXP = "exp"

    /**
     * **epoch-seconds**
     * Not Before
     *
     * [RFC7519, Section 4.1.5](https://www.rfc-editor.org/rfc/rfc7519.html#section-4.1.5)
     */
    const val NBF = "nbf"

    /**
     * **epoch-seconds**
     * Issued At
     *
     * [RFC7519, Section 4.1.6](https://www.rfc-editor.org/rfc/rfc7519.html#section-4.1.6)
     */
    const val IAT = "iat"

    /**
     * **string**
     * JWT ID
     *
     * [RFC7519, Section 4.1.7](https://www.rfc-editor.org/rfc/rfc7519.html#section-4.1.7)
     */
    const val JTI = "jti"

    //

    /**
     * **string**
     * End-User's full name in displayable form including all name parts, possibly including titles and suffixes,
     * ordered according to the End-User's locale and preferences.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val NAME = "name"

    /**
     * **string**
     * Given name(s) or first name(s) of the End-User. Note that in some cultures, people can have multiple given
     * names; all can be present, with the names being separated by space characters.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val GIVEN_NAME = "given_name"

    /**
     * **string**
     * Surname(s) or last name(s) of the End-User. Note that in some cultures, people can have multiple family names
     * or no family name; all can be present, with the names being separated by space characters.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val FAMILY_NAME = "family_name"

    /**
     * **string**
     * Middle name(s) of the End-User. Note that in some cultures, people can have multiple middle names; all can be
     * present, with the names being separated by space characters. Also note that in some cultures, middle names
     * are not used.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val MIDDLE_NAME = "middle_name"

    /**
     * **string**
     * Casual name of the End-User that may or may not be the same as the given_name. For instance, a nickname value
     * of Mike might be returned alongside a given_name value of Michael.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val NICKNAME = "nickname"

    /**
     * **string**
     * Shorthand name by which the End-User wishes to be referred to at the RP, such as janedoe or j.doe. This value
     * MAY be any valid JSON string including special characters such as @, /, or whitespace. The RP MUST NOT rely
     * upon this value being unique, as discussed in Section 5.7.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val PREFERRED_USERNAME = "preferred_username"

    /**
     * **string**
     * URL of the End-User's profile page. The contents of this Web page SHOULD be about the End-User.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val PROFILE = "profile"

    /**
     * **string**
     * URL of the End-User's profile picture. This URL MUST refer to an image file (for example, a PNG, JPEG, or GIF
     * image file), rather than to a Web page containing an image. Note that this URL SHOULD specifically reference
     * a profile photo of the End-User suitable for displaying when describing the End-User, rather than an
     * arbitrary photo taken by the End-User.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val PICTURE = "picture"

    /**
     * **string**
     * URL of the End-User's Web page or blog. This Web page SHOULD contain information published by the End-User or
     * an organization that the End-User is affiliated with.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val WEBSITE = "website"

    /**
     * **string**
     * End-User's preferred e-mail address. Its value MUST conform to the RFC 5322 addr-spec syntax. The RP MUST NOT
     * rely upon this value being unique, as discussed in Section 5.7.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val EMAIL = "email"

    /**
     * **boolean**
     * True if the End-User's e-mail address has been verified; otherwise false. When this Claim Value is true, this
     * means that the OP took affirmative steps to ensure that this e-mail address was controlled by the End-User at
     * the time the verification was performed. The means by which an e-mail address is verified is context-specific,
     * and dependent upon the trust framework or contractual agreements within which the parties are operating.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val EMAIL_VERIFIED = "email_verified"

    /**
     * **string**
     * End-User's gender. Values defined by this specification are female and male. Other values MAY be used when
     * neither of the defined values are applicable.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val GENDER = "gender"

    /**
     * **string**
     * End-User's birthday, represented as an ISO 8601:2004 [ISO8601‑2004] YYYY-MM-DD format. The year MAY be 0000,
     * indicating that it is omitted. To represent only the year, YYYY format is allowed. Note that depending on the
     * underlying platform's date related function, providing just year can result in varying month and day, so the
     * implementers need to take this factor into account to correctly process the dates.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val BIRTHDATE = "birthdate"

    /**
     * **string**
     * String from zoneinfo time zone database representing the End-User's time zone. For example, Europe/Paris or
     * America/Los_Angeles.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val ZONEINFO = "zoneinfo"

    /**
     * **string**
     * End-User's locale, represented as a BCP47 `RFC5646` language tag. This is typically an ISO 639-1 Alpha-2
     * [ISO639‑1] language code in lowercase and an ISO 3166-1 Alpha-2 [ISO3166‑1] country code in uppercase,
     * separated by a dash. For example, en-US or fr-CA. As a compatibility note, some implementations have used an
     * underscore as the separator rather than a dash, for example, en_US; Relying Parties MAY choose to accept this
     * locale syntax as well.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val LOCALE = "locale"

    /**
     * **string**
     * End-User's preferred telephone number. E.164 `E.164` is RECOMMENDED as the format of this Claim, for example,
     * +1 (425) 555-1212 or +56 (2) 687 2400. If the phone number contains an extension, it is RECOMMENDED that the
     * extension be represented using the RFC 3966 extension syntax,
     * for example, +1 (604) 555-1234;ext=5678.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val PHONE_NUMBER = "phone_number"

    /**
     * **boolean**
     * True if the End-User's phone number has been verified; otherwise false. When this Claim Value is true, this
     * means that the OP took affirmative steps to ensure that this phone number was controlled by the End-User at
     * the time the verification was performed. The means by which a phone number is verified is context-specific,
     * and dependent upon the trust framework or contractual agreements within which the parties are operating. When
     * true, the phone_number Claim MUST be in E.164 format and any extensions MUST be represented in RFC 3966
     * format.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val PHONE_NUMBER_VERIFIED = "phone_number_verified"

    /**
     * **object**
     * End-User's preferred postal address.
     * The value of the address member is a JSON `RFC4627` structure containing some or all of the members defined in Section 5.1.1.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val ADDRESS = "address"

    /**
     * The members of the [ADDRESS] claim.
     */
    object Address {
        // Custom; added for convenience

        /**
         * The name of the address given by the user.
         */
        const val LABEL = "label"

        // https://openid.net/specs/openid-connect-core-1_0.html#AddressClaim

        /**
         * Full mailing address, formatted for display or use on a mailing label. This field MAY contain multiple
         * lines, separated by newlines. Newlines can be represented either as a carriage return/line feed pair
         * ("\r\n") or as a single line feed character ("\n").
         *
         * [OIDC CORE 1.0 # 5.1.1 Address Claim](https://openid.net/specs/openid-connect-core-1_0.html#AddressClaim)
         */
        const val FORMATTED = "formatted"

        /**
         * Full street address component, which MAY include house number, street name, Post Office Box, and
         * multi-line extended street address information. This field MAY contain multiple lines, separated by
         * newlines. Newlines can be represented either as a carriage return/line feed pair ("\r\n") or as a single
         * line feed character ("\n").
         *
         * [OIDC CORE 1.0 # 5.1.1 Address Claim](https://openid.net/specs/openid-connect-core-1_0.html#AddressClaim)
         */
        const val STREET_ADDRESS = "street_address"

        /**
         * City or locality component.
         *
         * [OIDC CORE 1.0 # 5.1.1 Address Claim](https://openid.net/specs/openid-connect-core-1_0.html#AddressClaim)
         */
        const val LOCALITY = "locality"

        /**
         * State, province, prefecture, or region component.
         *
         * [OIDC CORE 1.0 # 5.1.1 Address Claim](https://openid.net/specs/openid-connect-core-1_0.html#AddressClaim)
         */
        const val REGION = "region"

        /**
         * Zip code or postal code component.
         *
         * [OIDC CORE 1.0 # 5.1.1 Address Claim](https://openid.net/specs/openid-connect-core-1_0.html#AddressClaim)
         */
        const val POSTAL_CODE = "postal_code"

        /**
         * Country name component.
         *
         * [OIDC CORE 1.0 # 5.1.1 Address Claim](https://openid.net/specs/openid-connect-core-1_0.html#AddressClaim)
         */
        const val COUNTRY = "country"
    }

    /**
     * **epoch-seconds**
     * Time the End-User's information was last updated. Its value is a JSON number representing the number of
     * seconds from 1970-01-01T0:0:0Z as measured in UTC until the date/time.
     *
     * [OIDC CORE 1.0 # 5.1 Standard Claims](https://openid.net/specs/openid-connect-core-1_0.html#StandardClaims)
     */
    const val UPDATED_AT = "updated_at"

    /**
     * **string**
     * OPTIONAL. Authorized party - the party to which the ID Token was issued.
     * If present, it MUST contain the OAuth 2.0 Client ID of this party.
     * This Claim is only needed when the ID Token has a single audience value and that audience is different than
     * the authorized party. It MAY be included even when the authorized party is the same as the sole audience.
     * The azp value is a case-sensitive string containing a StringOrURI value.
     *
     * [OIDC CORE 1.0 # 2 ID Token](https://openid.net/specs/openid-connect-core-1_0.html#IDToken)
     */
    const val AZP = "azp"

    /**
     * **string**
     * String value used to associate a Client session with an ID Token, and to mitigate replay attacks.
     * The value is passed through unmodified from the Authentication Request to the ID Token.
     * If present in the ID Token, Clients MUST verify that the nonce Claim Value is equal to the value of the nonce
     * parameter sent in the Authentication Request. If present in the Authentication Request, Authorization Servers
     * MUST include a nonce Claim in the ID Token with the Claim Value being the nonce value sent in the
     * Authentication Request. Authorization Servers SHOULD perform no other processing on nonce values used.
     * The nonce value is a case-sensitive string.
     *
     * [OIDC CORE 1.0 # 2 ID Token](https://openid.net/specs/openid-connect-core-1_0.html#IDToken)
     */
    const val NONCE = "nonce"

    /**
     * **epoch-seconds**
     * Time when the End-User authentication occurred.
     * Its value is a JSON number representing the number of seconds from 1970-01-01T0:0:0Z as measured in UTC until the date/time.
     * When a max_age request is made or when auth_time is requested as an Essential Claim, then this Claim is REQUIRED;
     * otherwise, its inclusion is OPTIONAL.
     *
     * [OIDC CORE 1.0 # 2 ID Token](https://openid.net/specs/openid-connect-core-1_0.html#IDToken)
     */
    const val AUTH_TIME = "auth_time"

    /**
     * **string**
     * Access Token hash value.
     * Its value is the base64url encoding of the left-most half of the hash of the octets of the ASCII
     * representation of the access_token value, where the hash algorithm used is the hash algorithm used in the alg
     * Header Parameter of the ID Token's JOSE Header.
     * For instance, if the alg is RS256, hash the access_token value with SHA-256, then take the left-most 128 bits
     * and base64url encode them.
     * The at_hash value is a case-sensitive string.
     * If the ID Token is issued from the Authorization Endpoint with an access_token value, which is the case for
     * the response_type value code id_token token, this is REQUIRED; otherwise, its inclusion is OPTIONAL.
     *
     * [OIDC CORE 1.0 # 3.3.2.11 Hybrid ID Token](https://openid.net/specs/openid-connect-core-1_0.html#HybridIDToken)
     */
    const val AT_HASH = "at_hash"

    /**
     * **string**
     * Code hash value.
     * Its value is the base64url encoding of the left-most half of the hash of the octets of the ASCII
     * representation of the code value, where the hash algorithm used is the hash algorithm used in the alg Header
     * Parameter of the ID Token's JOSE Header.
     * For instance, if the alg is HS512, hash the code value with SHA-512, then take the left-most 256 bits and
     * base64url encode them. The c_hash value is a case-sensitive string.
     * If the ID Token is issued from the Authorization Endpoint with a code, which is the case for the
     * response_type values code id_token and code id_token token, this is REQUIRED; otherwise, its inclusion is OPTIONAL.
     *
     * [OIDC CORE 1.0 # 3.3.2.11 Hybrid ID Token](https://openid.net/specs/openid-connect-core-1_0.html#HybridIDToken)
     */
    const val C_HASH = "c_hash"

    /**
     * **string**
     * OPTIONAL. Authentication Context Class Reference. String specifying an Authentication Context Class Reference
     * value that identifies the Authentication Context Class that the authentication performed satisfied.
     * The value "0" indicates the End-User authentication did not meet the requirements of ISO/IEC 29115 level 1.
     * Authentication using a long-lived browser cookie, for instance, is one example where the use of "level 0" is appropriate.
     * Authentications with level 0 SHOULD NOT be used to authorize access to any resource of any monetary value.
     * (This corresponds to the OpenID 2.0 PAPE nist_auth_level 0.) An absolute URI or an RFC 6711 registered name
     * SHOULD be used as the acr value; registered names MUST NOT be used with a different meaning than that which is registered.
     * Parties using this claim will need to agree upon the meanings of the values used, which may be context-specific.
     * The acr value is a case-sensitive string.
     *
     * [OIDC CORE 1.0 # 2 ID Token](https://openid.net/specs/openid-connect-core-1_0.html#IDToken)
     */
    const val ACR = "acr"

    /**
     * **string[]**
     * OPTIONAL. Authentication Methods References.
     * JSON array of strings that are identifiers for authentication methods used in the authentication.
     * For instance, values might indicate that both password and OTP authentication methods were used.
     * The definition of particular values to be used in the amr Claim is beyond the scope of this specification.
     * Parties using this claim will need to agree upon the meanings of the values used, which may be context-specific.
     * The amr value is an array of case-sensitive strings.
     *
     * [OIDC CORE 1.0 # 2 ID Token](https://openid.net/specs/openid-connect-core-1_0.html#IDToken)
     */
    const val AMR = "amr"

    //

    /**
     * Session ID
     */
    const val SID = "sid"

    //

    /**
     * Actor
     */
    const val ACT = "act"

    /**
     * Scope Values
     */
    const val SCOPE = "scope"

    /**
     * Client Identifier
     */
    const val CLIENT_ID = "client_id"

    /**
     * Authorized Actor - the party that is authorized to become the actor
     */
    const val MAY_ACT = "may_act"

    //

    /**
     * A list of roles for the user that collectively represent who the
     * user is, e.g., "Student", "Faculty".  No vocabulary or syntax is
     * specified, although it is expected that a role value is a String
     * or label representing a collection of entitlements.  This value
     * has no canonical types.
     *
     * [source](https://www.rfc-editor.org/rfc/rfc7643#section-4.1.2)
     */
    const val ROLES = "roles"

    /**
     * A list of groups to which the user belongs, either through direct
     * membership, through nested groups, or dynamically calculated.  The
     * values are meant to enable expression of common group-based or
     * role-based access control models, although no explicit
     * authorization model is defined.  It is intended that the semantics
     * of group membership and any behavior or authorization granted as a
     * result of membership are defined by the service provider.
     *
     * [source](https://www.rfc-editor.org/rfc/rfc7643#section-4.1.2)
     */
    const val GROUPS = "groups"

    /**
     * A list of entitlements for the user that represent a thing the
     * user has.  An entitlement may be an additional right to a thing,
     * object, or service.  No vocabulary or syntax is specified; service
     * providers and clients are expected to encode sufficient
     * information in the value so as to accurately and without ambiguity
     * determine what the user has access to.  This value has no
     * canonical types, although a type may be useful as a means to scope
     * entitlements.
     *
     * [source](https://www.rfc-editor.org/rfc/rfc7643#section-4.1.2)
     */
    const val ENTITLEMENTS = "entitlements"

    //

    /**
     * Token introspection response
     */
    const val TOKEN_INTROSPECTION = "token_introspection"

    //

    /**
     * This container Claim is composed of the verification evidence related
     * to a certain verification process and the corresponding Claims about
     * the End-User which were verified in this process.
     */
    const val VERIFIED_CLAIMS = "verified_claims"

    /**
     * A structured Claim representing the End-User's place of birth.
     */
    const val PLACE_OF_BIRTH = "place_of_birth"

    /**
     * String array representing the End-User's nationalities.
     */
    const val NATIONALITIES = "nationalities"

    /**
     * Family name(s) someone has when they were born, or at least from the
     * time they were a child. This term can be used by a person who changes
     * the family name(s) later in life for any reason. Note that in some
     * cultures, people can have multiple family names or no family name;
     * all can be present, with the names being separated by space characters.
     */
    const val BIRTH_FAMILY_NAME = "birth_family_name"

    /**
     * Given name(s) someone has when they were born, or at least from the time
     * they were a child. This term can be used by a person who changes the given
     * name later in life for any reason. Note that in some cultures, people can
     * have multiple given names; all can be present, with the names being separated
     * by space characters.
     */
    const val BIRTH_GIVEN_NAME = "birth_given_name"

    /**
     * Middle name(s) someone has when they were born, or at least from the time
     * they were a child. This term can be used by a person who changes the middle
     * name later in life for any reason. Note that in some cultures, people can
     * have multiple middle names; all can be present, with the names being separated
     * by space characters. Also note that in some cultures, middle names are not used.
     */
    const val BIRTH_MIDDLE_NAME = "birth_middle_name"

    /**
     * End-User's salutation, e.g., "Mr."
     */
    const val SALUTATION = "salutation"

    /**
     * End-User's title, e.g., "Dr."
     */
    const val TITLE = "title"

    /**
     * End-User's mobile phone number formatted according to ITU-T recommendation [`E.164`].
     */
    const val MSISDN = "msisdn"

    /**
     * Stage name, religious name or any other type of alias/pseudonym with which a person
     * is known in a specific context besides its legal name. This must be part of the
     * applicable legislation and thus the trust framework (e.g., be an attribute on the
     * identity card).
     */
    const val ALSO_KNOWN_AS = "also_known_as"

    //

    /**
     * JSON object whose member names are the Claim Names for the Aggregated and Distributed Claims.
     */
    const val CLAIM_NAMES = "_claim_names"

    /**
     * JSON object whose member names are referenced by the member values of the _claim_names member.
     */
    const val CLAIM_SOURCES = "_claim_sources"

    //

    /**
     * Public key used to check the signature of an ID Token.
     */
    const val SUB_JWK = "sub_jwk"

    /**
     * Confirmation
     */
    const val CNF = "cnf"

    /**
     * SIP From tag header field parameter value.
     */
    const val SIP_FROM_TAG = "sip_from_tag"

    /**
     * SIP Date header field value.
     */
    const val SIP_DATE = "sip_date"

    /**
     * SIP Call-Id header field value.
     */
    const val SIP_CALLID = "sip_callid"

    /**
     * SIP CSeq numeric header field parameter value.
     */
    const val SIP_CSEQ_NUM = "sip_cseq_num"

    /**
     * SIP Via branch header field parameter value.
     */
    const val SIP_VIA_BRANCH = "sip_via_branch"

    /**
     * Originating Identity String
     */
    const val ORIG = "orig"

    /**
     * Destination Identity String
     */
    const val DEST = "dest"

    /**
     * Media Key Fingerprint String
     */
    const val MKY = "mky"

    /**
     * Security Events
     */
    const val EVENTS = "events"

    /**
     * Time of Event
     */
    const val TOE = "toe"

    /**
     * Transaction Identifier
     */
    const val TXN = "txn"

    /**
     * Resource Priority Header Authorization
     */
    const val RPH = "rph"

    /**
     * Vector of Trust value
     */
    const val VOT = "vot"

    /**
     * Vector of Trust trustmark URL
     */
    const val VTM = "vtm"

    /**
     * Attestation level as defined in SHAKEN framework
     */
    const val ATTEST = "attest"

    /**
     * Originating Identifier as defined in SHAKEN framework
     */
    const val ORIGID = "origid"

    /**
     * jCard data
     */
    const val JCARD = "jcard"

    /**
     * Number of API requests for which the access token can be used
     */
    const val AT_USE_NBR = "at_use_nbr"

    /**
     * Diverted Target of a Call
     */
    const val DIV = "div"

    /**
     * Original PASSporT (in Full Form)
     */
    const val OPT = "opt"

    /**
     * Verifiable Credential as specified in the W3C Recommendation
     */
    const val VC = "vc"

    /**
     * Verifiable Presentation as specified in the W3C Recommendation
     */
    const val VP = "vp"

    /**
     * SIP Priority header field
     */
    const val SPH = "sph"

    /**
     * The ACE profile a token is supposed to be used with.
     */
    const val ACE_PROFILE = "ace_profile"

    /**
     * "client-nonce".
     * A nonce previously provided to the AS by the RS via the client.
     * Used to verify token freshness when the RS cannot synchronize
     * its clock with the AS.
     */
    const val CNONCE = "cnonce"

    /**
     * "Expires in".
     * Lifetime of the token in seconds from the time the RS first sees it.
     * Used to implement a weaker from of token expiration for devices that
     * cannot synchronize their internal clocks.
     */
    const val EXI = "exi"

    /**
     * CDNI Claim Set Version
     */
    const val CDNIV = "cdniv"

    /**
     * CDNI Critical Claims Set
     */
    const val CDNICRIT = "cdnicrit"

    /**
     * CDNI IP Address
     */
    const val CDNIIP = "cdniip"

    /**
     * CDNI URI Container
     */
    const val CDNIUC = "cdniuc"

    /**
     * CDNI Expiration Time Setting for Signed Token Renewal
     */
    const val CDNIETS = "cdniets"

    /**
     * CDNI Signed Token Transport Method for Signed Token Renewal
     */
    const val CDNISTT = "cdnistt"

    /**
     * CDNI Signed Token Depth
     */
    const val CDNISTD = "cdnistd"

    /**
     * Signature Validation Token
     */
    const val SIG_VAL_CLAIMS = "sig_val_claims"

    /**
     * The claim authorization_details contains a JSON array of JSON objects
     * representing the rights of the access token. Each JSON object contains
     * the data to specify the authorization requirements for a certain type
     * of resource.
     */
    const val AUTHORIZATION_DETAILS = "authorization_details"

    /**
     * The HTTP method of the request
     */
    const val HTM = "htm"

    /**
     * The HTTP URI of the request (without query and fragment parts)
     */
    const val HTU = "htu"

    /**
     * The base64url-encoded SHA-256 hash of the ASCII encoding of the associated access token's value.
     */
    const val ATH = "ath"

    /**
     * Authority Token Challenge
     */
    const val ATC = "atc"

    /**
     * Subject Identifier
     */
    const val SUB_ID = "sub_id"

    /**
     * Rich Call Data Information
     */
    const val RCD = "rcd"

    /**
     * Rich Call Data Integrity Information
     */
    const val RCDI = "rcdi"

    /**
     * Call Reason
     */
    const val CRN = "crn"

    /**
     * Message Integrity Information
     */
    const val MSGI = "msgi"
}
