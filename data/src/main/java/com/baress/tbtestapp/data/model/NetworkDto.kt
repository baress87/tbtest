package com.baress.tbtestapp.data.model

import com.squareup.moshi.Json
import java.io.Serializable

data class NetworkDto(
    @Json(name = "restaurantIdx") val restaurantIdx: Long,
    @Json(name = "thumbnail") val thumbnail: String,
    @Json(name = "classification") val classification: String,
    @Json(name = "restaurantName") val restaurantName: String,
    @Json(name = "rating") val rating: Double,
    @Json(name = "reviewCount") val reviewCount: Int,
    @Json(name = "summaryAddress") val summaryAddress: String,
    @Json(name = "isQuickBooking") val isQuickBooking: Boolean,
    @Json(name = "isRemoteWaiting") val isRemoteWaiting: Boolean,
    @Json(name = "useWaiting") val useWaiting: Boolean,
    @Json(name = "useBooking") val useBooking: Boolean,
    @Json(name = "isNew") val isNew: Boolean,
    @Json(name = "waitingCount") val waitingCount: Int
): Serializable
