/*
 * Copyright (c) 2021/5/10 - 8:23
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.di.module

import com.no.aka.baseprojectkotlin.repository.DetailRepository
import com.no.aka.baseprojectkotlin.repository.HomeRepository
import com.no.aka.baseprojectkotlin.repository.MapRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModel = module {
    single { HomeRepository(androidContext(), get(), get()) }
    single { DetailRepository() }
    single { MapRepository() }
}