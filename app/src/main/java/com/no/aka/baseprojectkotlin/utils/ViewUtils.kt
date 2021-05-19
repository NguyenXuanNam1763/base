package com.no.aka.baseprojectkotlin.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class ViewUtils {

    companion object {

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url: String?) {
            if (!url.isNullOrEmpty()) {
                Glide.with(view.context).load(url).into(view)
                return
            }
        }


    }

    fun convertTime(textView: TextView, long: Long) {
        val formatsMilliSeconds = TimeUtils.formatsMilliSeconds(long)
        formatsMilliSeconds?.let {
            textView.text = it
        }
    }
}