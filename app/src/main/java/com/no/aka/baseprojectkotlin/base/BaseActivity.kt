/*
 * Copyright (c) 2021/5/10 - 5:54
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.no.aka.baseprojectkotlin.receiver.InternetReceiver
import com.no.aka.baseprojectkotlin.utils.NetworkHelper
import com.skydoves.bindables.BindingActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity<viewBd : ViewDataBinding>(viewId: Int) :
    BindingActivity<viewBd>(viewId),
    CoroutineScope {

    private lateinit var job: Job

    private var internetReceiver: InternetReceiver? = null
    private var fragmentManager: FragmentManager? = null

    private var isConnectInternet = false
    private var idViewReplaceFragment = 0

    abstract fun initView(savedInstanceState: Bundle?)

    @SuppressLint("MissingSuperCall")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView((this.binding as ViewBinding).root)
        this.job = Job()
        this.initView(savedInstanceState)
        this.checkInternet()
        this.initFragmentManager()
    }

    private fun checkInternet() {
        this.isConnectInternet = NetworkHelper(this).isNetworkConnected()
        this.internetReceiver = InternetReceiver.getIntenseInternet(this)
        this.internetReceiver?.setChangeInternet(object : InternetReceiver.ChangeInternet {
            override fun connect() {
                if (!isConnectInternet) {
                    isConnectInternet = true
                    connectInternet()
                }
            }

            override fun disconnect() {
                if (isConnectInternet) {
                    isConnectInternet = true
                    disconnectInternet()
                }
            }
        })
    }

    private fun initFragmentManager() {
        this.fragmentManager = supportFragmentManager
    }

    fun setIdReplaceFragment(idView: Int) {
        this.idViewReplaceFragment = idView
    }


    fun connectInternet() {

    }

    fun disconnectInternet() {

    }

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        if (this.idViewReplaceFragment == 0) {
            Log.i("namnx", "replaceFragment: Change id replace")
            return
        }

        this.fragmentManager?.let {
            val fragmentTransaction = it.beginTransaction()
            fragmentTransaction.replace(this.idViewReplaceFragment, fragment)
            if (addToBackStack) {
                fragmentTransaction.addToBackStack(fragment::class.java.name)
            }

            fragmentTransaction.commitAllowingStateLoss()
        }
    }

    private fun removeFragmentWhenBackPress() {
        if (this.idViewReplaceFragment == 0) {
            return
        }
        this.fragmentManager?.let {
            val emptyStack = it.backStackEntryCount == 0
            if (emptyStack) {
                finish()
            }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onLowMemory() {
        super.onLowMemory()
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.removeFragmentWhenBackPress()
    }

    override fun onDestroy() {
        this.job.cancel()
        this.internetReceiver?.unRegister(this)
        super.onDestroy()
    }

}