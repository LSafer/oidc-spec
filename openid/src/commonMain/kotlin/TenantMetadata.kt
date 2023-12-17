package net.lsafer.oidc.openid

/**
 * Metadata about a tenant that is passed either by value or by reference with
 * an authorization request.
 *
 * The whole concept of tenants is not part of openid and is an extension.
 */
object TenantMetadata {
    /**
     * True if the Tenant has been manually verified (deserves verification badge)
     */
    const val VERIFIED = "verified"

    /**
     * **`String<email>[]? = null`**
     *
     * OPTIONAL. Array of e-mail addresses of people responsible for this Tenant. This might be used by some providers
     * to enable a Web user interface to modify the Tenant information.
     */
    const val CONTACTS = "contacts"

    /**
     * **`String? = null`** (i18n)
     *
     * OPTIONAL. Name of the Tenant to be presented to the End-User. If desired, representation of this Claim in
     * different languages and scripts is represented as described in Section 2.1.
     */
    const val TENANT_NAME = "tenant_name"

    /**
     * **`String? = null`** (i18n)
     *
     * OPTIONAL. URL that references a logo for the Tenant application. If present, the server SHOULD display this image
     * to the End-User during approval. The value of this field MUST point to a valid image file. If desired,
     * representation of this Claim in different languages and scripts is represented as described in Section 2.1.
     */
    const val LOGO_URI = "logo_uri"

    /**
     * **`String<uri>? = null`** (i18n)
     *
     * OPTIONAL. URL of the home page of the Tenant. The value of this field MUST point to a valid Web page. If present,
     * the server SHOULD display this URL to the End-User in a followable fashion. If desired, representation of this
     * Claim in different languages and scripts is represented as described in Section 2.1.
     */
    const val TENANT_URI = "tenant_uri"

    /**
     * **`String<uri>? = null`** (i18n)
     *
     * OPTIONAL. URL that the Relying Party Tenant provides to the End-User to read about the how the profile data will
     * be used. The value of this field MUST point to a valid web page. The OpenID Provider SHOULD display this URL to
     * the End-User if it is given. If desired, representation of this Claim in different languages and scripts is
     * represented as described in Section 2.1.
     */
    const val POLICY_URI = "policy_uri"

    /**
     * **`String<uri>? = null`** (i18n)
     *
     * OPTIONAL. URL that the Relying Party Tenant provides to the End-User to read about the Relying Party's terms of
     * service. The value of this field MUST point to a valid web page. The OpenID Provider SHOULD display this URL to
     * the End-User if it is given. If desired, representation of this Claim in different languages and scripts is
     * represented as described in Section 2.1.
     */
    const val TOS_URI = "tos_uri"
}
