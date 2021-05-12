/*
 * Copyright (c) 2021/5/10 - 8:13
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.skydoves.bindables.BindingViewModel
import kotlinx.coroutines.Dispatchers

abstract class BaseViewModel : BindingViewModel() {
    inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T> {
        return liveData(viewModelScope.coroutineContext + Dispatchers.IO)
        {
            emitSource(block())
        }
    }
}