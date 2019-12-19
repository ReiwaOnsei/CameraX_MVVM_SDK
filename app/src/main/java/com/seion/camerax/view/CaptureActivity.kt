package com.seion.camerax.app.view

import androidx.fragment.app.Fragment
import com.seion.camerax.sdk.base.BaseActivity

class CaptureActivity : BaseActivity() {
    override fun createFragment(): Fragment {
        return CaptureFragment.newInstance()
    }
}
