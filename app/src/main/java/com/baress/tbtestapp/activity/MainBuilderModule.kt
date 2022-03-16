package com.baress.tbtestapp.activity

import com.baress.tbtestapp.fragment.main.MainFragment
import com.baress.tbtestapp.fragment.main.recent.RecentFragment
import com.baress.tbtestapp.fragment.main.save.SaveFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            MainFragmentBuilderModule::class,
            SaveFragmentBuilderModule::class,
            RecentFragmentBuilderModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}

@Module
abstract class MainFragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}

@Module
abstract class SaveFragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeSaveFragment(): SaveFragment
}

@Module
abstract class RecentFragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeRecentFragment(): RecentFragment
}
