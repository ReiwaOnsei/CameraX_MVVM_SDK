package com.seion.camerax.app.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.example.cameraxbasic.R
import com.android.example.cameraxbasic.databinding.FragmentHomeTopBinding
import com.seion.camerax.sdk.base.BaseFragment
import com.seion.camerax.sdk.base.BaseViewModel

class HomeTopFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeTopBinding
    var viewModel = vm as HomeTopViewModel

    override fun createViewModel(): BaseViewModel = ViewModelProvider.NewInstanceFactory().create(
        HomeTopViewModel::class.java
    )

    companion object {
        fun newInstance() = HomeTopFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_top, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun initData() {
        super.initData()

        viewModel.isClickBtn.observe(this, Observer {
            if (it) {
                startActivity(Intent(activity, CaptureActivity::class.java))
                activity?.finish()
            }
        })

    }

    override fun initView(){}
}