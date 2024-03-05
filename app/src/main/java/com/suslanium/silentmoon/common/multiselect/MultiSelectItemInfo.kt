package com.suslanium.silentmoon.common.multiselect

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.suslanium.silentmoon.R

object MultiSelectItems {
    val items = List(3) { listOf(
        MultiSelectItemInfo(
            R.drawable.all_icon, R.string.meditate_v2_menu_all
        ), MultiSelectItemInfo(
            R.drawable.my_icon, R.string.meditate_v2_menu_my
        ), MultiSelectItemInfo(
            R.drawable.anxious_icon, R.string.meditate_v2_menu_anxious
        ), MultiSelectItemInfo(
            R.drawable.sleep_icon_z, R.string.meditate_v2_menu_sleep
        ), MultiSelectItemInfo(
            R.drawable.kids_icon, R.string.meditate_v2_menu_kids
        )
    ) }.flatten()
}

data class MultiSelectItemInfo(
    @DrawableRes val iconId: Int, @StringRes val titleId: Int
)