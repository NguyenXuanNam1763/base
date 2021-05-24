package com.no.aka.baseprojectkotlin.view.ui.detail

import android.os.Bundle
import com.no.aka.baseprojectkotlin.R
import com.no.aka.baseprojectkotlin.base.BaseActivity
import com.no.aka.baseprojectkotlin.databinding.ActivityDetailBinding
import com.no.aka.baseprojectkotlin.model.ObjectActivity
import com.no.aka.baseprojectkotlin.model.ProductSale
import com.no.aka.baseprojectkotlin.utils.TimeUtils
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    private lateinit var productSale: ProductSale
    private val detailViewModel: DetailViewModel by viewModel()

    override fun initView(savedInstanceState: Bundle?) {
        this.productSale = ObjectActivity.objectData as ProductSale
        this.productSale ?: return
        this.binding.apply {
            product = productSale
            tvTime.text = TimeUtils.formatMillisecondToDay(productSale.timeSale!!)
        }

        this.detailViewModel.countDownTimer()
        this.detailViewModel.timeLiveData.observe(this, {
            this.binding.apply {
                tvTime.text = TimeUtils.formatMillisecondToDay(productSale.timeSale!!)
            }
        })

    }
}