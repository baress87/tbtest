package com.baress.tbtestapp

import android.content.Context
import com.baress.tbtestapp.activity.MainActivityModule
import com.baress.tbtestapp.data.di.DataLayerModule
import com.baress.tbtestapp.data.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        DataLayerModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        MainActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder
        fun build(): AppComponent
    }
}
