package com.no.aka.baseprojectkotlin.repository

import android.os.Handler
import android.os.Looper
import com.no.aka.baseprojectkotlin.base.BaseRepository

class DetailRepository : BaseRepository() {
    private var handler: Handler? = null
    private var runnable: Runnable? = null

    fun countDownTimer(onNextTime: (currentTime: Long) -> Unit) {
        this.handler = Handler(Looper.getMainLooper())

        this.runnable = object : Runnable {
            override fun run() {
                onNextTime(System.currentTimeMillis())
                handler?.postDelayed(this, 1000)
            }
        }

        this.handler?.post(this.runnable as Runnable)
    }

    fun destroy() {
        this.runnable?.let { this.handler?.removeCallbacks(it) }
    }
}