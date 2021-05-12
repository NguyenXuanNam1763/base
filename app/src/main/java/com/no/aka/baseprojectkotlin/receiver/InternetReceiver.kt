package com.no.aka.baseprojectkotlin.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import com.no.aka.baseprojectkotlin.utils.NetworkHelper

class InternetReceiver : BroadcastReceiver() {
    private var changeInternet: ChangeInternet? = null


    companion object {
        fun getIntenseInternet(context: Context?): InternetReceiver? {
            context?.let {
                val internetReceiver = InternetReceiver()
                val intentFilter = IntentFilter()
                with(intentFilter)
                {
                    addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
                    addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
                    addAction(ConnectivityManager.CONNECTIVITY_ACTION)
                }
                context.registerReceiver(internetReceiver, intentFilter)
                return internetReceiver
            }

            return null
        }
    }

    fun unRegister(context: Context?) {
        context?.let {
            try {
                context.unregisterReceiver(this)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun setChangeInternet(changeInternet: ChangeInternet) {
        this.changeInternet = changeInternet
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        this.changeInternet?.let {
            this.isOnline(onConnect = {
                it.connect()
            }, onDisconnect = {
                it.disconnect()
            }, context)
        }
    }

    private fun isOnline(
        onConnect: () -> Unit,
        onDisconnect: () -> Unit,
        context: Context?
    ) {
        context?.let {
            val networkHelper = NetworkHelper(context).isNetworkConnected()
            if (networkHelper) {
                onConnect()
                return
            }

            onDisconnect()
        }
        onDisconnect()
    }

    public interface ChangeInternet {
        fun connect()
        fun disconnect()
    }
}