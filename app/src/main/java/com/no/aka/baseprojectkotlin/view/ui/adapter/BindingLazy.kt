/*
 * Copyright (c) 2021/5/10 - 10:51
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.view.ui.adapter

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

inline fun <reified T : ViewDataBinding> bindings(view: View): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE) {
        requireNotNull(DataBindingUtil.bind(view))
    }