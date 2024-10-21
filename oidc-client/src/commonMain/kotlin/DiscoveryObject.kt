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
package net.lsafer.oidc.client

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import net.lsafer.oidc.client.internal.asBooleanOrNull
import net.lsafer.oidc.client.internal.asStringListOrNull
import net.lsafer.oidc.client.internal.asStringOrNull
import net.lsafer.oidc.openid.DiscoveryMetadata.ACR_VALUES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.AUTHORIZATION_ENDPOINT
import net.lsafer.oidc.openid.DiscoveryMetadata.CLAIMS_LOCALES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.CLAIMS_PARAMETER_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.CLAIMS_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.CLAIM_TYPES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.DISPLAY_VALUES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.GRANT_TYPES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.ID_TOKEN_ENCRYPTION_ALG_VALUES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.ID_TOKEN_ENCRYPTION_ENC_VALUES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.ISSUER
import net.lsafer.oidc.openid.DiscoveryMetadata.JWKS_URI
import net.lsafer.oidc.openid.DiscoveryMetadata.OP_POLICY_URI
import net.lsafer.oidc.openid.DiscoveryMetadata.OP_TOS_URI
import net.lsafer.oidc.openid.DiscoveryMetadata.REGISTRATION_ENDPOINT
import net.lsafer.oidc.openid.DiscoveryMetadata.REQUEST_OBJECT_ENCRYPTION_ALG_VALUES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.REQUEST_OBJECT_ENCRYPTION_ENC_VALUES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.REQUEST_OBJECT_SIGNING_ALG_VALUES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.REQUEST_PARAMETER_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.REQUEST_URI_PARAMETER_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.REQUIRE_REQUEST_URI_REGISTRATION
import net.lsafer.oidc.openid.DiscoveryMetadata.RESPONSE_MODES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.RESPONSE_TYPES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.SCOPES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.SERVICE_DOCUMENTATION
import net.lsafer.oidc.openid.DiscoveryMetadata.SUBJECT_TYPES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.TOKEN_ENDPOINT
import net.lsafer.oidc.openid.DiscoveryMetadata.TOKEN_ENDPOINT_AUTH_METHODS_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.TOKEN_ENDPOINT_AUTH_SIGNING_ALG_VALUES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.UI_LOCALES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.USERINFO_ENCRYPTION_ALG_VALUES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.USERINFO_ENCRYPTION_ENC_VALUES_SUPPORTED
import net.lsafer.oidc.openid.DiscoveryMetadata.USERINFO_ENDPOINT
import net.lsafer.oidc.openid.DiscoveryMetadata.USERINFO_SIGNING_ALG_VALUES_SUPPORTED
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
@Suppress("PropertyName")
value class DiscoveryObject(val value: JsonObject) {
    private fun boolean(name: String) = value[name]?.asBooleanOrNull
    private fun string(name: String) = value[name]?.asStringOrNull
    private fun stringList(name: String) = value[name]?.asStringListOrNull

    val issuer get() = string(ISSUER)
    val authorization_endpoint get() = string(AUTHORIZATION_ENDPOINT)
    val token_endpoint get() = string(TOKEN_ENDPOINT)
    val userinfo_endpoint get() = string(USERINFO_ENDPOINT)
    val jwks_uri get() = string(JWKS_URI)
    val registration_endpoint get() = string(REGISTRATION_ENDPOINT)
    val scopes_supported get() = stringList(SCOPES_SUPPORTED)
    val response_types_supported get() = stringList(RESPONSE_TYPES_SUPPORTED)
    val response_modes_supported get() = stringList(RESPONSE_MODES_SUPPORTED)
    val grant_types_supported get() = stringList(GRANT_TYPES_SUPPORTED)
    val acr_values_supported get() = stringList(ACR_VALUES_SUPPORTED)
    val subject_types_supported get() = stringList(SUBJECT_TYPES_SUPPORTED)
    val id_token_signing_alg_values_supported get() = stringList(ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED)
    val id_token_encryption_alg_values_supported get() = stringList(ID_TOKEN_ENCRYPTION_ALG_VALUES_SUPPORTED)
    val id_token_encryption_enc_values_supported get() = stringList(ID_TOKEN_ENCRYPTION_ENC_VALUES_SUPPORTED)
    val userinfo_signing_alg_values_supported get() = stringList(USERINFO_SIGNING_ALG_VALUES_SUPPORTED)
    val userinfo_encryption_alg_values_supported get() = stringList(USERINFO_ENCRYPTION_ALG_VALUES_SUPPORTED)
    val userinfo_encryption_enc_values_supported get() = stringList(USERINFO_ENCRYPTION_ENC_VALUES_SUPPORTED)
    val request_object_signing_alg_values_supported get() = stringList(REQUEST_OBJECT_SIGNING_ALG_VALUES_SUPPORTED)
    val request_object_encryption_alg_values_supported
        get() = stringList(REQUEST_OBJECT_ENCRYPTION_ALG_VALUES_SUPPORTED)
    val request_object_encryption_enc_values_supported
        get() = stringList(REQUEST_OBJECT_ENCRYPTION_ENC_VALUES_SUPPORTED)
    val token_endpoint_auth_methods_supported get() = stringList(TOKEN_ENDPOINT_AUTH_METHODS_SUPPORTED)
    val token_endpoint_auth_signing_alg_values_supported
        get() = stringList(TOKEN_ENDPOINT_AUTH_SIGNING_ALG_VALUES_SUPPORTED)
    val display_values_supported get() = stringList(DISPLAY_VALUES_SUPPORTED)
    val claim_types_supported get() = stringList(CLAIM_TYPES_SUPPORTED)
    val claims_supported get() = stringList(CLAIMS_SUPPORTED)
    val service_documentation get() = string(SERVICE_DOCUMENTATION)
    val claims_locales_supported get() = stringList(CLAIMS_LOCALES_SUPPORTED)
    val ui_locales_supported get() = stringList(UI_LOCALES_SUPPORTED)
    val claims_parameter_supported get() = boolean(CLAIMS_PARAMETER_SUPPORTED)
    val request_parameter_supported get() = boolean(REQUEST_PARAMETER_SUPPORTED)
    val request_uri_parameter_supported get() = boolean(REQUEST_URI_PARAMETER_SUPPORTED)
    val require_request_uri_registration get() = boolean(REQUIRE_REQUEST_URI_REGISTRATION)
    val op_policy_uri get() = string(OP_POLICY_URI)
    val op_tos_uri get() = string(OP_TOS_URI)
}
