package com.baress.tbtestapp.data.repository

import com.baress.tbtestapp.data.api.NetworkService
import com.baress.tbtestapp.data.model.mapToDomain
import com.baress.tbtestapp.domain.SchedulerProvider
import com.baress.tbtestapp.domain.model.NetworkResponseEntity
import com.baress.tbtestapp.domain.repository.NetworkRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkRepositoryImpl @Inject constructor(
    private val networkService: NetworkService,
    private val schedulerProvider: SchedulerProvider
) : NetworkRepository {

    override fun getSaveList(): Single<NetworkResponseEntity> =
        networkService.getSaveList()
            .map { res -> res.mapToDomain() }
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.mainThread)

    override fun getRecentList(): Single<NetworkResponseEntity> =
        networkService.getRecentList()
            .map { res -> res.mapToDomain() }
            .subscribeOn(schedulerProvider.io)
            .observeOn(schedulerProvider.mainThread)
}
