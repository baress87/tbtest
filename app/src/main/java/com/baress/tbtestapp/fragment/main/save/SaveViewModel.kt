package com.baress.tbtestapp.fragment.main.save

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baress.tbtestapp.domain.model.NetworkEntity
import com.baress.tbtestapp.domain.repository.NetworkRepository
import javax.inject.Inject

class SaveViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private var _saveList = MutableLiveData<List<NetworkEntity>>()
    val saveList: LiveData<List<NetworkEntity>>
        get() = _saveList

    @SuppressLint("CheckResult")
    fun getSaveList() {
        networkRepository.getSaveList().subscribe { res ->
            _saveList.value = res.list
        }
    }
}
