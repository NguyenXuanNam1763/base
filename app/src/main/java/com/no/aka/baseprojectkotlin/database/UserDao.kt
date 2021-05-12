/*
 * Copyright (c) 2021/5/10 - 6:59
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.database

import androidx.room.Dao
import androidx.room.Query
import com.no.aka.baseprojectkotlin.model.User

@Dao
interface UserDao : BaseDao<User> {

    @Query("select * from tbUser")
    suspend fun getUsers(): List<User>
}