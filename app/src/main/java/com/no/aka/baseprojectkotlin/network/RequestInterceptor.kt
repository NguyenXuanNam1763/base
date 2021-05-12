/*
 * Copyright (c) 2021/5/10 - 6:43
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.network

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val request = originalRequest.newBuilder().url(originalRequest.url).build()
        return chain.proceed(request)
    }

}