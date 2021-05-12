/*
 * Copyright (c) 2021/5/10 - 5:59
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.skydoves.bindables.BindingFragment

abstract class BaseFragment<viewBd : ViewDataBinding>(viewId: Int) :
    BindingFragment<viewBd>(viewId) {

    abstract fun initView(savedInstanceState: Bundle?)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.initView(savedInstanceState)
        return (this.binding as ViewBinding).root
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}