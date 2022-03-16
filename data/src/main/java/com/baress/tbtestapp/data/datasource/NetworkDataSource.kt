package com.baress.tbtestapp.data.datasource

import com.baress.tbtestapp.data.model.NetworkResponse
import io.reactivex.Single

interface NetworkDataSource {
    fun getSaveList(): Single<NetworkResponse>

    fun getRecentList(): Single<NetworkResponse>
}
