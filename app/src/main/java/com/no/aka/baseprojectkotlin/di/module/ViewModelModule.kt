/*
 * Copyright (c) 2021/5/10 - 10:25
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.di.module

import com.no.aka.baseprojectkotlin.view.ui.detail.DetailViewModel
import com.no.aka.baseprojectkotlin.view.ui.home.HomeViewModel
import com.no.aka.baseprojectkotlin.view.ui.map.MapViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { MapViewModel(get()) }
}