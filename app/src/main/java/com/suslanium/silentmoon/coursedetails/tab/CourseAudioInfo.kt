package com.suslanium.silentmoon.coursedetails.tab

import androidx.annotation.StringRes
import com.suslanium.silentmoon.R

object CourseAudio {
    val courseAudioInfos = listOf(
        CourseAudioInfo(
            isActive = true, titleId = R.string.focus_attention, duration = 10
        ),
        CourseAudioInfo(
            isActive = false, titleId = R.string.body_scan, duration = 5
        ),
        CourseAudioInfo(
            isActive = false, titleId = R.string.making_happiness, duration = 3
        ),
        CourseAudioInfo(
            isActive = false, titleId = R.string.focus_attention, duration = 10
        ),
        CourseAudioInfo(
            isActive = false, titleId = R.string.body_scan, duration = 5
        ),
        CourseAudioInfo(
            isActive = false, titleId = R.string.making_happiness, duration = 3
        ),
        CourseAudioInfo(
            isActive = false, titleId = R.string.focus_attention, duration = 10
        ),
        CourseAudioInfo(
            isActive = false, titleId = R.string.body_scan, duration = 5
        ),
        CourseAudioInfo(
            isActive = false, titleId = R.string.making_happiness, duration = 3
        ),
    )
}

data class CourseAudioInfo(
    val isActive: Boolean, @StringRes val titleId: Int, val duration: Int
)