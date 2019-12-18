package com.seion.camerax.app.view

import androidx.lifecycle.MutableLiveData
import com.seion.camerax.sdk.base.BaseViewModel

class HomeTopViewModel : BaseViewModel() {

    val isClickBtn by lazy { MutableLiveData<Boolean>() }

    fun onStartCaptureButton() {
        isClickBtn.postValue(true)
    }
}