package com.suslanium.silentmoon.common.sleepmusic

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.suslanium.silentmoon.R

object SleepMusic {
    val list = List(2) {
        listOf(
            SleepMusicInfo(
                imageId = R.drawable.night_island_bg, titleId = R.string.night_island, duration = 45
            ), SleepMusicInfo(
                imageId = R.drawable.sweet_sleep_bg, titleId = R.string.sweet_sleep, duration = 45
            ), SleepMusicInfo(
                imageId = R.drawable.moon_clouds_bg_one,
                titleId = R.string.good_night,
                duration = 45
            ), SleepMusicInfo(
                imageId = R.drawable.moon_clouds_bg_two,
                titleId = R.string.moon_clouds,
                duration = 45
            ), SleepMusicInfo(
                imageId = R.drawable.sweet_sleep_bg, titleId = R.string.sweet_sleep, duration = 45
            ), SleepMusicInfo(
                imageId = R.drawable.night_island_bg, titleId = R.string.night_island, duration = 45
            ), SleepMusicInfo(
                imageId = R.drawable.moon_clouds_bg_one,
                titleId = R.string.good_night,
                duration = 45
            ), SleepMusicInfo(
                imageId = R.drawable.moon_clouds_bg_two,
                titleId = R.string.moon_clouds,
                duration = 45
            )
        )
    }.flatten()
}

data class SleepMusicInfo(
    @DrawableRes val imageId: Int, @StringRes val titleId: Int, val duration: Int
)