/*
 * Copyright (c) 2021/5/10 - 8:12
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.repository

import android.os.Handler
import android.os.Looper
import com.no.aka.baseprojectkotlin.base.BaseRepository
import com.no.aka.baseprojectkotlin.database.UserDao
import com.no.aka.baseprojectkotlin.model.ProductSale
import com.no.aka.baseprojectkotlin.model.User
import com.no.aka.baseprojectkotlin.network.ApiService
import com.skydoves.sandwich.ApiResponse
import retrofit2.Response

class HomeRepository(private val userDao: UserDao, private val apiService: ApiService) :
    BaseRepository() {

    private var handler: Handler? = null
    private var runnable: Runnable? = null

    suspend fun getUsers(): Response<List<User>> {
        return this.apiService.getUsers()
    }

    suspend fun getProducts(): Response<List<ProductSale>> {
        return this.apiService.getProductSale()
    }

    fun countDownTime(onNextTime: () -> Unit) {
        this.handler = Handler(Looper.getMainLooper())

        this.runnable = object : Runnable {
            override fun run() {
                onNextTime()
                handler?.postDelayed(this, 1000)
            }
        }

        this.handler?.post(this.runnable as Runnable)
    }


    fun destroy() {
        this.runnable?.let { this.handler?.removeCallbacks(it) }
    }

}