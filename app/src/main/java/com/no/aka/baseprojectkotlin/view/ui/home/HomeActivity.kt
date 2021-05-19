/*
 * Copyright (c) 2021/5/10 - 8:13
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.view.ui.home

import android.os.Bundle
import com.no.aka.baseprojectkotlin.R
import com.no.aka.baseprojectkotlin.base.BaseActivity
import com.no.aka.baseprojectkotlin.databinding.ActivityHomeBinding
import com.no.aka.baseprojectkotlin.view.ui.adapter.ProductAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var productAdapter: ProductAdapter

    override fun initView(savedInstanceState: Bundle?) {
        this.homeViewModel.fetchProducts()
        this.productAdapter = ProductAdapter()
        this.binding.productAdapter = productAdapter
        this.homeViewModel.productsLiveData.observe(this, {
            this.productAdapter.addSection(it)
            this.productAdapter.notifyDataSetChanged()
        })
    }
}