/*
 * Copyright (c) 2021/5/10 - 8:12
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.repository

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.google.gson.Gson
import com.no.aka.baseprojectkotlin.base.BaseRepository
import com.no.aka.baseprojectkotlin.database.UserDao
import com.no.aka.baseprojectkotlin.model.ProductSale
import com.no.aka.baseprojectkotlin.model.User
import com.no.aka.baseprojectkotlin.network.ApiService
import org.json.JSONArray
import retrofit2.Response

class HomeRepository(private val context: Context, private val userDao: UserDao, private val apiService: ApiService) :
        BaseRepository() {

    private var handler: Handler? = null
    private var runnable: Runnable? = null

    suspend fun getUsers(): Response<List<User>> {
        return this.apiService.getUsers()
    }

    fun getProducts(): List<ProductSale> {
        val fileInString: String =
                context.assets.open("test.json").bufferedReader().use { it.readText() }
        val jsonArray = JSONArray(fileInString)
        val gson = Gson()
        val productSales = mutableListOf<ProductSale>()
        for (i in 0 until jsonArray.length()) {
            val productSale = gson.fromJson(jsonArray[i].toString(), ProductSale::class.java)
            productSales.add(productSale)
        }

        return productSales
//        return this.apiService.getProductSale()
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