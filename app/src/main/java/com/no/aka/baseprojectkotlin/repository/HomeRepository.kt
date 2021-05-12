/*
 * Copyright (c) 2021/5/10 - 8:12
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.repository

import com.no.aka.baseprojectkotlin.base.BaseRepository
import com.no.aka.baseprojectkotlin.database.UserDao
import com.no.aka.baseprojectkotlin.model.User
import com.no.aka.baseprojectkotlin.network.ApiService
import com.skydoves.sandwich.ApiResponse

class HomeRepository(private val userDao: UserDao, private val apiService: ApiService) :
    BaseRepository() {

    suspend fun getUsers(): ApiResponse<List<User>> {
        return this.apiService.getUsers()
    }
}