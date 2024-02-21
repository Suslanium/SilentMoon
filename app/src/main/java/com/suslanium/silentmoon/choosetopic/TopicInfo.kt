package com.suslanium.silentmoon.choosetopic

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.suslanium.silentmoon.R

object Topics {
    val topicList = List(2) {
        listOf(
            TopicInfo(
                topicImageId = R.drawable.topic_stress,
                topicTitleId = R.string.topic_stress,
                topicBackgroundColorId = R.color.light_blue,
                topicTitleColorId = R.color.light_yellow,
                imagePaddingTopDp = 0,
                isSmall = false
            ),
            TopicInfo(
                topicImageId = R.drawable.topic_performance,
                topicTitleId = R.string.topic_performance,
                topicBackgroundColorId = R.color.light_red,
                topicTitleColorId = R.color.topic_performance_title_color,
                imagePaddingTopDp = 10,
                isSmall = true
            ),
            TopicInfo(
                topicImageId = R.drawable.topic_anxiety,
                topicTitleId = R.string.topic_anxiety,
                topicBackgroundColorId = R.color.topic_anxiety_bg_color,
                topicTitleColorId = R.color.primary_text,
                imagePaddingTopDp = 15,
                isSmall = false
            ),
            TopicInfo(
                topicImageId = R.drawable.topic_happiness,
                topicTitleId = R.string.topic_happiness,
                topicBackgroundColorId = R.color.topic_happiness_bg_color,
                topicTitleColorId = R.color.primary_text,
                imagePaddingTopDp = 0,
                isSmall = true
            ),
            TopicInfo(
                topicImageId = R.drawable.topic_growth,
                topicTitleId = R.string.topic_growth,
                topicBackgroundColorId = R.color.light_green,
                topicTitleColorId = R.color.light_yellow,
                imagePaddingTopDp = 9,
                isSmall = false
            ),
            TopicInfo(
                topicImageId = R.drawable.topic_sleep,
                topicTitleId = R.string.topic_sleep,
                topicTitleColorId = R.color.very_light_gray,
                topicBackgroundColorId = R.color.primary_text,
                imagePaddingTopDp = 10,
                isSmall = true
            ),
            TopicInfo(
                topicImageId = R.drawable.topic_productivity,
                topicTitleId = R.string.topic_productivity,
                topicBackgroundColorId = R.color.topic_productivity_bg_color,
                topicTitleColorId = R.color.very_light_gray,
                imagePaddingTopDp = 17,
                isSmall = true
            ),
            TopicInfo(
                topicImageId = R.drawable.topic_stress_2,
                topicTitleId = R.string.topic_stress,
                topicBackgroundColorId = R.color.facebook,
                topicTitleColorId = R.color.very_light_gray,
                imagePaddingTopDp = 0,
                isSmall = false
            )
        )
    }.flatten()
}

data class TopicInfo(
    @DrawableRes val topicImageId: Int,
    @StringRes val topicTitleId: Int,
    @ColorRes val topicBackgroundColorId: Int,
    @ColorRes val topicTitleColorId: Int,
    val imagePaddingTopDp: Int,
    val isSmall: Boolean
)
