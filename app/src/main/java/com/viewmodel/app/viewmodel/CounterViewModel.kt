package com.viewmodel.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    private val _liveData = MutableLiveData<Int>()

    val liveData: LiveData<Int> = _liveData

    init {
        _liveData.value = 0
    }

    fun increment() {
        _liveData.value = _liveData.value!! + 1
    }

    fun decrement() {
        _liveData.value = _liveData.value!! - 1
    }
}