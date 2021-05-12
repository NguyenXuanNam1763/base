/*
 * Copyright (c) 2021/5/10 - 8:21
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.view.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.no.aka.baseprojectkotlin.base.BaseViewModel
import com.no.aka.baseprojectkotlin.model.User
import com.no.aka.baseprojectkotlin.repository.HomeRepository
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.launch

class HomeViewModel(val homeRepository: HomeRepository) : BaseViewModel() {
    private val usersMutableList = MutableLiveData<List<User>>()
    val userLiveData: LiveData<List<User>>
        get() {
            return usersMutableList
        }

    fun getUsers() {
        viewModelScope.launch {
            homeRepository.getUsers()
                .suspendOnSuccess {
                    data?.let {
                        usersMutableList.value = it
                    }
                }
                .suspendOnError {

                }
        }
    }

}