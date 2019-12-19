package com.seion.camerax.sdk.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import com.android.example.cameraxbasic.R

abstract class BaseActivity : AppCompatActivity(), LifecycleObserver {

    protected abstract fun createFragment(): Fragment
    protected lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_container)

        var fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (fragment == null) {

            fragment = createFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }
        this.fragment = fragment
        classLoader
    }
}