/*
 * Copyright (c) 2021/5/10 - 8:21
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.view.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.no.aka.baseprojectkotlin.base.BaseViewModel
import com.no.aka.baseprojectkotlin.model.ProductSale
import com.no.aka.baseprojectkotlin.model.User
import com.no.aka.baseprojectkotlin.repository.HomeRepository
import kotlinx.coroutines.launch
import java.util.*

class HomeViewModel(private val homeRepository: HomeRepository) : BaseViewModel() {
    private val usersMutableList = MutableLiveData<List<User>>()
    val userLiveData: LiveData<List<User>>
        get() {
            return usersMutableList
        }

    private val productMutableList = MutableLiveData<List<ProductSale>>()
    val productsLiveData: LiveData<List<ProductSale>>
        get() = productMutableList

    private val itemChangeMutable = MutableLiveData<Int>()
    val itemChange: LiveData<Int>
        get() = itemChangeMutable

    fun fetchProducts() {
//        viewModelScope.launch {
//                .suspendOnSuccess {
//                    Log.i("namnx", "fetchProducts: ${data?.size}")
//                }

        val products = homeRepository.getProducts()
//            if (products.isSuccessful) {
        productMutableList.value = products
                initCountDownTime()
//                return@launch
//            }
//
//
//        }
    }

    private fun initCountDownTime() {
        homeRepository.countDownTime {

            val value = productMutableList.value
            val list = mutableListOf<ProductSale>()
            value?.forEachIndexed(action = { index, productSale ->
                val timeCurrent = System.currentTimeMillis()
                if (productSale.timeSale!! - timeCurrent > 1000) {
                    list.add(productSale)
                }
            })

            productMutableList.value = list ?: emptyList()

        }
    }


    override fun onCleared() {
        this.homeRepository.destroy()
        super.onCleared()
    }

}