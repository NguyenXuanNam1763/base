/*
 * Copyright (c) 2021/5/10 - 10:35
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.view.ui.adapter

import android.view.View
import com.no.aka.baseprojectkotlin.R
import com.no.aka.baseprojectkotlin.databinding.ViewItemUserBinding
import com.no.aka.baseprojectkotlin.model.User
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import com.skydoves.baserecyclerviewadapter.SectionRow

class UserAdapter() : BaseAdapter() {

    override fun layout(sectionRow: SectionRow): Int {
        return R.layout.view_item_user
    }

    override fun viewHolder(layout: Int, view: View): BaseViewHolder {
        return UserViewHolder(view)
    }

    inner class UserViewHolder(view: View) : BaseViewHolder(view) {

        private val binding: ViewItemUserBinding by bindings(view)
        override fun bindData(data: Any) {
            if (data is User) {
                this.drawItemUi()
            }
        }

        private fun drawItemUi() {

        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

        override fun onLongClick(v: View?): Boolean {
            TODO("Not yet implemented")
        }
    }


}