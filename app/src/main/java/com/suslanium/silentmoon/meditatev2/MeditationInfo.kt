package com.suslanium.silentmoon.meditatev2

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.suslanium.silentmoon.R

object Meditations {
    val list = List(3) {
        listOf(
            MeditationInfo(
                backgroundId = R.drawable.meditate_card_one_bg,
                blurId = R.drawable.meditate_card_one_blur,
                titleId = R.string.seven_days_of_calm,
                isTallItem = true
            ),
            MeditationInfo(
                backgroundId = R.drawable.meditate_card_two_bg,
                blurId = R.drawable.meditate_card_two_blur,
                titleId = R.string.anxiety_release,
                isTallItem = false
            ),
            MeditationInfo(
                backgroundId = R.drawable.meditate_card_three_bg,
                blurId = R.drawable.meditate_card_three_blur,
                titleId = R.string.seven_days_of_calm,
                isTallItem = true
            ),
            MeditationInfo(
                backgroundId = R.drawable.meditate_card_four_bg,
                blurId = R.drawable.meditate_card_four_blur,
                titleId = R.string.anxiety_release,
                isTallItem = false
            )
        )
    }.flatten()
}

data class MeditationInfo(
    @DrawableRes val backgroundId: Int,
    @DrawableRes val blurId: Int,
    @StringRes val titleId: Int,
    val isTallItem: Boolean
)