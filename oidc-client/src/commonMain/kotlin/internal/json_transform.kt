package net.lsafer.oidc.client.internal

import kotlinx.datetime.Instant
import kotlinx.serialization.json.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/** if this json element is a json string, return its content. Otherwise, return `null`. */
internal inline val JsonPrimitive.stringOrNull get() = if (isString) content else null

/** if this json element is a json primitive, return it. Otherwise, return `null`. */
internal inline val JsonElement.asJsonPrimitiveOrNull: JsonPrimitive? get() = this as? JsonPrimitive

/** if this json element is a json number, return its content as [Long]. Otherwise, return `null`. */
internal inline val JsonElement.asLongOrNull: Long? get() = asJsonPrimitiveOrNull?.longOrNull

/** if this json element is a json boolean, return its content. Otherwise, return `null`. */
internal inline val JsonElement.asBooleanOrNull: Boolean? get() = asJsonPrimitiveOrNull?.booleanOrNull

/** if this json element is a json string, return its content. Otherwise, return `null`. */
internal inline val JsonElement.asStringOrNull: String? get() = asJsonPrimitiveOrNull?.stringOrNull

/** if this json element is a json array, return it. Otherwise, return `null`. */
internal inline val JsonElement.asJsonArrayOrNull: JsonArray? get() = this as? JsonArray

//

internal inline val JsonElement.asStringListOrNull: List<String>?
    get() = asJsonArrayOrNull?.map { it.asStringOrNull ?: return null }

internal inline val JsonElement.asDurationFromSeconds: Duration?
    get() = asLongOrNull?.seconds

internal inline val JsonElement.asInstantFromEpochSeconds: Instant?
    get() = asLongOrNull?.let { Instant.fromEpochSeconds(it) }
