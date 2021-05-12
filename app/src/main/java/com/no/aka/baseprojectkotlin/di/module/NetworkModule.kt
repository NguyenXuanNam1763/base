/*
 * Copyright (c) 2021/5/10 - 6:44
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.di.module

import com.no.aka.baseprojectkotlin.network.ApiService
import com.no.aka.baseprojectkotlin.network.RequestInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl("https://5e510330f2c0d300147c034c.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(ApiService::class.java) }
}