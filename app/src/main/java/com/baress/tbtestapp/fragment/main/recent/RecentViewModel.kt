package com.baress.tbtestapp.fragment.main.recent

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baress.tbtestapp.domain.model.NetworkEntity
import com.baress.tbtestapp.domain.repository.NetworkRepository
import javax.inject.Inject

class RecentViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private var _recentList = MutableLiveData<List<NetworkEntity>>()
    val recentList: LiveData<List<NetworkEntity>>
        get() = _recentList

    @SuppressLint("CheckResult")
    fun getRecentList() {
        networkRepository.getRecentList().subscribe { res ->
            _recentList.value = res.list
        }
    }
}
