package com.seion.camerax.app

import androidx.fragment.app.Fragment
import com.seion.camerax.sdk.base.BaseActivity
import com.seion.camerax.app.view.HomeTopFragment

class HomeTopActivity : BaseActivity() {
    override fun createFragment(): Fragment {
        return HomeTopFragment.newInstance()
    }
}
