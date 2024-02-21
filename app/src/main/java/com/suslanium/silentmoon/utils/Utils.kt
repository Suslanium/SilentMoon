package com.suslanium.silentmoon.utils

import android.content.Context
import android.util.DisplayMetrics

object Utils {
    fun convertDpToPixel(dp: Float, context: Context): Float {
        return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

}