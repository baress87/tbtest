package com.baress.tbtestapp.data.model

import android.os.RemoteException
import com.baress.tbtestapp.domain.model.NetworkEntity
import com.baress.tbtestapp.domain.model.NetworkResponseEntity
import com.squareup.moshi.FromJson
import com.squareup.moshi.Json

data class NetworkResponse(val list: List<NetworkDto>) {

    data class Raw(
        @Json(name = "list") val networkDtoList: List<NetworkDto>? = null
    )

    class Adapter {

        @FromJson
        fun fromJson(raw: Raw): NetworkResponse =
            if (raw.networkDtoList != null) {
                NetworkResponse(raw.networkDtoList)
            } else {
                throw RemoteException()
            }
    }
}

fun NetworkResponse.mapToDomain() =
    NetworkResponseEntity(
        list.mapToDomain()
    )

fun List<NetworkDto>.mapToDomain(): List<NetworkEntity> =
    map { networkDto ->
        NetworkEntity(
            networkDto.restaurantIdx,
            networkDto.thumbnail,
            networkDto.classification,
            networkDto.restaurantName,
            networkDto.rating,
            networkDto.reviewCount,
            networkDto.summaryAddress,
            networkDto.isQuickBooking,
            networkDto.isRemoteWaiting,
            networkDto.useWaiting,
            networkDto.useBooking,
            networkDto.isNew,
            networkDto.waitingCount
        )
    }
