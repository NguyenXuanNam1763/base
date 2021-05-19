/*
 * Copyright (c) 2021/5/10 - 8:21
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.view.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.no.aka.baseprojectkotlin.base.BaseViewModel
import com.no.aka.baseprojectkotlin.model.ProductSale
import com.no.aka.baseprojectkotlin.model.User
import com.no.aka.baseprojectkotlin.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : BaseViewModel() {
    private val usersMutableList = MutableLiveData<List<User>>()
    val userLiveData: LiveData<List<User>>
        get() {
            return usersMutableList
        }

    private val productMutableList = MutableLiveData<List<ProductSale>>()
    val productsLiveData: LiveData<List<ProductSale>>
        get() = productMutableList

    private val timeObservable = MutableLiveData<Int>()
    val timeLiveData: LiveData<Int>
        get() = timeObservable

    fun fetchProducts() {
        viewModelScope.launch {
//                .suspendOnSuccess {
//                    Log.i("namnx", "fetchProducts: ${data?.size}")
//                }

            val products = homeRepository.getProducts()
            if (products.isSuccessful) {
                productMutableList.value = products.body()
                initCountDownTime()
                return@launch
            }


        }
    }

    private fun initCountDownTime() {
        homeRepository.countDownTime {
            val value = productMutableList.value
            value?.forEachIndexed(action = { index, productSale ->
                if (productSale.timeSale!! > 1000) {
                    productSale.timeSale = productSale.timeSale!! - 1000
                } else {
                    productSale.timeSale = 0
                }
            })
            value?.let {
                productMutableList.value = it
            }
            timeObservable.value = 1
        }
    }


    override fun onCleared() {
        this.homeRepository.destroy()
        super.onCleared()
    }

}