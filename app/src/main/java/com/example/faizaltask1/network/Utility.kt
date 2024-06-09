package com.foreverinlove.network

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.provider.Settings
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import android.util.Log
import android.view.*
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat


@SuppressLint("StaticFieldLeak")
object Utility {

    private var progressBar: ProgressBar? = null
    private var windowTop: Window? = null


    // show progressbar
    fun Activity.showProgressBar() {
        hideProgressBar()
        Log.d(TAG, "showProgressBar: testflowCheckingProgressState >> VISIBLE")

        try {
            val layout =
                (this as? Activity)?.findViewById<View>(android.R.id.content)?.rootView as? ViewGroup
            progressBar = ProgressBar(this, null)
            progressBar?.let { it1 ->
                it1.isIndeterminate = true
                windowTop = window
                window.setFlags(
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                )
                val params = RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT
                )
                val rl = RelativeLayout(this)
                rl.gravity = Gravity.CENTER
                rl.addView(it1)
                layout?.addView(rl, params)
                it1.visibility = View.VISIBLE
            }
            Log.d(TAG, "showProgressBar: VISIBLE")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private const val TAG = "Utility"

    // hide progressbar
    fun hideProgressBar() {
        Log.d(TAG, "showProgressBar: testflowCheckingProgressState >> GONE")
        try {
            progressBar?.let {
                it.visibility = View.GONE
            }
            windowTop?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}