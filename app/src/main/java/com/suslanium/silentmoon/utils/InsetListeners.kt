package com.suslanium.silentmoon.utils

import android.view.ViewGroup
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams

object InsetListeners {
    val marginTopBottomListener = OnApplyWindowInsetsListener { view, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
        view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            bottomMargin = insets.bottom
            topMargin = insets.top
        }

        WindowInsetsCompat.CONSUMED
    }

    val marginTopListener = OnApplyWindowInsetsListener { view, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

        view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = insets.top
        }

        WindowInsetsCompat.CONSUMED
    }

    val marginBottomListener = OnApplyWindowInsetsListener { view, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

        view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            bottomMargin = insets.bottom
        }

        WindowInsetsCompat.CONSUMED
    }

    val heightBottomListener = OnApplyWindowInsetsListener { view, windowInsets ->
        val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

        view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            height = insets.bottom
        }

        WindowInsetsCompat.CONSUMED
    }
}