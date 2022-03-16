package com.baress.tbtestapp.data.api

import com.baress.tbtestapp.data.model.NetworkResponse
import io.reactivex.Single
import retrofit2.http.GET

interface NetworkService {

    @GET(RESOURCE_URL + "save")
    fun getSaveList(): Single<NetworkResponse>

    @GET(RESOURCE_URL + "recent")
    fun getRecentList(): Single<NetworkResponse>

    companion object {

        private const val RESOURCE_URL = "tabling_mobile_test/"
    }
}
