package com.suslanium.silentmoon.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.suslanium.silentmoon.R

object Recommendations {
    val recommendationsList = List(3) {
        listOf(
            RecommendationInfo(
                imageDrawableId = R.drawable.focus_bg, titleId = R.string.focus
            ), RecommendationInfo(
                imageDrawableId = R.drawable.happiness_bg, titleId = R.string.happiness
            )
        )
    }.flatten()
}

data class RecommendationInfo(
    @DrawableRes val imageDrawableId: Int, @StringRes val titleId: Int
)