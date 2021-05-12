/*
 * Copyright (c) 2021/5/11 - 8:43
 * File created by NamNx
 */

package com.no.aka.baseprojectkotlin.base

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.viewbinding.ViewBinding

abstract class BaseDialog<T : Context, ViewBd>(context: T, viewBd: ViewBd) {
    private var binding: ViewBd? = null
    private var context: T? = null
    private var alertDialog: AlertDialog? = null
    private var dialogBuilder: AlertDialog.Builder? = null

    init {
        this.context = context
        this.dialogBuilder = AlertDialog.Builder(context)
        this.binding = viewBd
    }

    fun show(isCancelable: Boolean, showKeyboard: Boolean) {
        this.dialogBuilder?.setView((this.binding as ViewBinding).root)
        if (this.alertDialog == null) {
            this.alertDialog = this.dialogBuilder?.create()
            alertDialog!!.setOnDismissListener { onDismissDialog() }
        }

        this.alertDialog?.setCancelable(isCancelable)
        this.alertDialog?.setCanceledOnTouchOutside(isCancelable)
        try {
            val window = this.alertDialog?.window
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            if (showKeyboard) {
                window?.setSoftInputMode(5)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        this.alertDialog?.show()

    }

    protected fun onDismissDialog() {

    }

    fun getBinding(): ViewBd? {
        return this.binding
    }
}