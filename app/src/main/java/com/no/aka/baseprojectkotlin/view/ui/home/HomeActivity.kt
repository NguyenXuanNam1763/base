/*
 * Copyright (c) 2021/5/10 - 8:13
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.view.ui.home

import android.os.Bundle
import android.util.Log
import com.no.aka.baseprojectkotlin.R
import com.no.aka.baseprojectkotlin.base.BaseActivity
import com.no.aka.baseprojectkotlin.databinding.ActivityHomeBinding
import com.no.aka.baseprojectkotlin.view.ui.adapter.ProductAdapter
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var productAdapter: ProductAdapter
    private lateinit var paginator: RecyclerViewPaginator

    override fun initView(savedInstanceState: Bundle?) {
        this.homeViewModel.fetchProducts()
        this.productAdapter = ProductAdapter()
        this.binding.productAdapter = productAdapter
        this.homeViewModel.productsLiveData.observe(this, {
            this.productAdapter.clearAllSections()
            this.productAdapter.addSection(it)
            this.productAdapter.notifyDataSetChanged()
        })

        this.homeViewModel.itemChange.observe(this, {
            this.productAdapter.notifyItemRemoved(it)
        })

        this.homeViewModel.productSaveLive.observe(this, {
            val sizeLasts = this.productAdapter.itemCount
            this.productAdapter.addSection(it)
            val sizeCurrent = this.productAdapter.itemCount
            this.productAdapter.notifyItemRangeChanged(sizeLasts, sizeCurrent)
        })

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, 2021)
        calendar.set(Calendar.MONTH, 4)
        calendar.set(Calendar.DAY_OF_MONTH, 19)
        calendar.set(Calendar.HOUR_OF_DAY, 15)
        calendar.set(Calendar.MINUTE, 54)
        calendar.set(Calendar.SECOND, 0)


        this.paginator = RecyclerViewPaginator(
            recyclerView = binding.rvProduct,
            onLast = { false },
            loadMore = { loadMore() },
            isLoading = { false }
        )
    }

    private fun loadMore() {
        this.homeViewModel.loadMore(productAdapter.itemCount)
    }
}