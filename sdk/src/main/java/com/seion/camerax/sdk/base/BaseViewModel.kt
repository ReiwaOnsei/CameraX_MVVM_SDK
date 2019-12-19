package com.seion.camerax.sdk.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(), LifecycleObserver {

    open fun initData(){}
}