package com.baress.tbtestapp.data.di

import com.baress.tbtestapp.data.DefaultSchedulerProvider
import com.baress.tbtestapp.data.datasource.NetworkDataSource
import com.baress.tbtestapp.data.datasource.NetworkDataSourceImpl
import com.baress.tbtestapp.data.repository.NetworkRepositoryImpl
import com.baress.tbtestapp.domain.SchedulerProvider
import com.baress.tbtestapp.domain.repository.NetworkRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataLayerBindingModule::class])
class DataLayerModule {

    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider = DefaultSchedulerProvider
}

@Module
interface DataLayerBindingModule {

    @Binds
    fun bindNetworksRepository(impl: NetworkRepositoryImpl): NetworkRepository

    @Binds
    fun bindNetworkDataSource(impl: NetworkDataSourceImpl): NetworkDataSource
}
