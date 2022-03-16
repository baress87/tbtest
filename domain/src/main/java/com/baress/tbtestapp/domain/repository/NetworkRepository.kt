package com.baress.tbtestapp.domain.repository

import com.baress.tbtestapp.domain.model.NetworkResponseEntity
import io.reactivex.Single

interface NetworkRepository {

    fun getSaveList(): Single<NetworkResponseEntity>

    fun getRecentList(): Single<NetworkResponseEntity>
}
