/*
 * Copyright (c) 2021/5/10 - 6:55
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.no.aka.baseprojectkotlin.model.User

@Database(entities = [User::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}