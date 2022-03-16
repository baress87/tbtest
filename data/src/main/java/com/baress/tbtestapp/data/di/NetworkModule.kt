package com.baress.tbtestapp.data.di

import com.baress.tbtestapp.data.MoshiUtils
import com.baress.tbtestapp.data.api.NetworkService
import com.baress.tbtestapp.data.model.NetworkResponse
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module
object NetworkModule {

    @Named("Network")
    @Provides
    fun provideRetrofit(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.NONE
        } as Interceptor

        val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor)
        val moshi = MoshiUtils.Factory {
            add(NetworkResponse.Adapter())
        }.create()

        return Retrofit.Builder().apply {
            client(okHttpClient.build())
            baseUrl("https://my-json-server.typicode.com/tabling/")
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            addConverterFactory(MoshiConverterFactory.create(moshi))
        }.build()
    }

    @Provides
    fun provideNetworkService(@Named("Network") retrofit: Retrofit): NetworkService =
        retrofit.create(NetworkService::class.java)
}
