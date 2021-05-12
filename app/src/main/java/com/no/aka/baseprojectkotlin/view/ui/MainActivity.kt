/*
 * Copyright (c) 2021/5/10 - 7:42
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.view.ui

import android.os.Bundle
import com.no.aka.baseprojectkotlin.R
import com.no.aka.baseprojectkotlin.base.BaseActivity
import com.no.aka.baseprojectkotlin.database.UserDao
import com.no.aka.baseprojectkotlin.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val userDao: UserDao by inject()

    override fun initView(savedInstanceState: Bundle?) {
    }

}