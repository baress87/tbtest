package com.baress.tbtestapp.data.datasource

import com.baress.tbtestapp.data.api.NetworkService
import com.baress.tbtestapp.data.model.NetworkResponse
import io.reactivex.Single
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
    private val api: NetworkService
) : NetworkDataSource {
    override fun getSaveList(): Single<NetworkResponse> =
        api.getSaveList()

    override fun getRecentList(): Single<NetworkResponse> =
        api.getRecentList()
}
