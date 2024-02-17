package com.suslanium.silentmoon

import android.view.ViewGroup
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams

object InsetListeners {
    val topBottomListener = OnApplyWindowInsetsListener { view, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
        view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            bottomMargin = insets.bottom
            topMargin = insets.top
        }

        WindowInsetsCompat.CONSUMED
    }

    val topListener = OnApplyWindowInsetsListener { view, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

        view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = insets.top
        }

        WindowInsetsCompat.CONSUMED
    }

    val bottomListener = OnApplyWindowInsetsListener { view, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

        view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            bottomMargin = insets.bottom
        }

        WindowInsetsCompat.CONSUMED
    }
}