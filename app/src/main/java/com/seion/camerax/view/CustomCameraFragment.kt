package com.seion.camerax.app.view

import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.example.cameraxbasic.R
import com.android.example.cameraxbasic.databinding.FragmentCameraCaptureBinding
import com.android.example.cameraxbasic.fragments.CameraFragment
import com.android.example.cameraxbasic.utils.ImageUtils
import com.bumptech.glide.Glide
import com.seion.camerax.sdk.base.BaseViewModel
import kotlinx.android.synthetic.main.fragment_camera_capture.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class CustomCameraFragment : CameraFragment(){
    override fun setGalleryThumbnail(file: File) {
        // Reference of the view that holds the gallery thumbnail
        val thumbnail = photo_view_button

        // Use a coroutine to perform thumbnail operations in background
        launch(coroutineContext) {

            // Create thumbnail for this photo
            val bitmap = ImageUtils.decodeBitmap(file)

            // Crop the bitmap into a circle for the thumbnail
            val thumbnailBitmap = ImageUtils.cropCircularThumbnail(bitmap)

            // Set the foreground drawable if we can, fallback using Glide
            // This must be done in the main thread, so use main thread's context
            withContext(Dispatchers.Main) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    thumbnail.foreground = BitmapDrawable(resources, thumbnailBitmap)
                } else {
                    Glide.with(requireContext()).load(thumbnailBitmap).into(thumbnail)
                }
            }
        }
    }

    override fun initData() {
        super.initData()

        vModel.isReviewPicture.observe(this, Observer {
            Toast.makeText(context, "照片预览:${it.exists()} ${it.name}", Toast.LENGTH_LONG).show()
        })
    }

    override fun isDocumentCaptureOver(file: File) {
        Toast.makeText(context, "照片信息:${file.exists()} ${file.name}", Toast.LENGTH_LONG).show()
    }

    private lateinit var fragmentCameraCaptureBinding: FragmentCameraCaptureBinding
    var vModel = vm as CustomCameraViewModel

    companion object {
        fun newInstance() = CustomCameraFragment()
    }

    override fun createViewModel(): BaseViewModel = ViewModelProvider.NewInstanceFactory().create(
        CustomCameraViewModel::class.java
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        fragmentCameraCaptureBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_camera_capture, container, false)

        fragmentCameraCaptureBinding.lifecycleOwner = this
        fragmentCameraCaptureBinding.viewModel = vModel

        return fragmentCameraCaptureBinding.root
    }

}
