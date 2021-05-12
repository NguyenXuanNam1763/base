/*
 * Copyright (c) 2021/5/10 - 6:54
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.di.module

import androidx.room.Room
import com.no.aka.baseprojectkotlin.R
import com.no.aka.baseprojectkotlin.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            androidApplication().getString(R.string.app_name)
        ).fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().userDao() }

}