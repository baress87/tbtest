package com.baress.tbtestapp

import androidx.lifecycle.ViewModel
import com.baress.tbtestapp.fragment.main.recent.RecentViewModel
import com.baress.tbtestapp.fragment.main.save.SaveViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SaveViewModel::class)
    abstract fun bindSaveViewModel(saveViewModel: SaveViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RecentViewModel::class)
    abstract fun bindRecentViewModel(recentViewModel: RecentViewModel): ViewModel
}
