package com.android.example.cameraxbasic.fragments

import androidx.lifecycle.MutableLiveData
import com.seion.camerax.sdk.base.BaseViewModel
import java.io.File

abstract class CameraViewModel : BaseViewModel() {
    val takePicture by lazy { MutableLiveData<Boolean>() }
    val isCaptureCompleted by lazy { MutableLiveData<File>() }
    abstract fun onTakePicture()
}