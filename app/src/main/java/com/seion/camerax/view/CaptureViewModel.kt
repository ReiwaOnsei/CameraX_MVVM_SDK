package com.seion.camerax.app.view

import androidx.lifecycle.MutableLiveData
import com.android.example.cameraxbasic.fragments.CameraViewModel
import java.io.File

class CaptureViewModel : CameraViewModel() {
    val isReviewPicture by lazy { MutableLiveData<File>() }

   override fun onTakePicture() {
       takePicture.postValue(true)
   }

    fun onReviewPicture(){
        isReviewPicture.postValue(isCaptureCompleted.value)
    }
}