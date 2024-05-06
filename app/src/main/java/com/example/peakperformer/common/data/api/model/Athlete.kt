package com.example.peakperformer.common.data.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Athlete(
    val id: Int,
    val username: String,
    @Json(name = "resource_state") val resourceState: Int,
    val firstname: String,
    val lastname: String,
    val bio: String,
    val city: String,
    val state: String,
    val country: String,
    val sex: String,
    val premium: Boolean,
    val summit: Boolean,
    @Json(name = "created_at")val createdAt: String,
    @Json(name = "updated_at")val updatedAt: String,
    @Json(name = "badge_type_id")val badgeTypeId: Int,
    val weight: Double,
    @Json(name = "profile_medium") val profileMedium: String,
    val profile: String,
    val friend: Any?,
    val follower: Any?
)
