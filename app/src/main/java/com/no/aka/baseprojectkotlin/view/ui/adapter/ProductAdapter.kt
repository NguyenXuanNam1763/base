package com.no.aka.baseprojectkotlin.view.ui.adapter

import android.view.View
import com.no.aka.baseprojectkotlin.R
import com.no.aka.baseprojectkotlin.databinding.ViewItemProductBinding
import com.no.aka.baseprojectkotlin.model.ProductSale
import com.no.aka.baseprojectkotlin.utils.TimeUtils
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import com.skydoves.baserecyclerviewadapter.SectionRow

class ProductAdapter : BaseAdapter() {
    override fun layout(sectionRow: SectionRow): Int {
        return R.layout.view_item_product
    }

    override fun viewHolder(layout: Int, view: View): BaseViewHolder {
        return ProductViewHolder(view)
    }

    inner class ProductViewHolder(view: View) : BaseViewHolder(view) {

        private val binding: ViewItemProductBinding by bindings(view)
        private var productSale: ProductSale? = null
        override fun bindData(data: Any) {
            if (data is ProductSale) {
                this.productSale = data
                this.drawUI()
            }
        }

        private fun drawUI() {
            binding.apply {
                tvTime.text = TimeUtils.formatsMilliSeconds(productSale?.timeSale!!)
                product = productSale
            }
        }


        override fun onClick(v: View?) {
        }

        override fun onLongClick(v: View?): Boolean {
            return true
        }

    }
}