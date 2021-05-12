/*
 * Copyright (c) 2021/5/10 - 6:31
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.network

import com.no.aka.baseprojectkotlin.model.User
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("")
    suspend fun getUsers(): ApiResponse<List<User>>
}