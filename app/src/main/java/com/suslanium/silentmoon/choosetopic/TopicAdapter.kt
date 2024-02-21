package com.suslanium.silentmoon.choosetopic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.updateMargins
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.RecyclerView
import com.suslanium.silentmoon.R
import com.suslanium.silentmoon.databinding.TopicViewholderBinding
import com.suslanium.silentmoon.utils.Utils


class TopicAdapter(private val topics: List<TopicInfo>) :
    RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    private lateinit var context: Context

    inner class TopicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = TopicViewholderBinding.bind(view)

        fun bind(topicInfo: TopicInfo) = with(binding) {
            val layoutParams = FrameLayout.LayoutParams(
                context.resources.getDimensionPixelSize(R.dimen.topic_item_width),
                if (topicInfo.isSmall) context.resources.getDimensionPixelSize(R.dimen.topic_item_small_height) else context.resources.getDimensionPixelSize(
                    R.dimen.topic_item_height
                )
            )
            layoutParams.updateMargins(
                left = context.resources.getDimensionPixelSize(R.dimen.topic_item_horizontal_margin),
                right = context.resources.getDimensionPixelSize(R.dimen.topic_item_horizontal_margin),
                bottom = context.resources.getDimensionPixelSize(R.dimen.topic_item_bottom_margin)
            )
            binding.topicHolderRoot.layoutParams = layoutParams
            binding.topicHolderRoot.backgroundTintList = context.getColorStateList(topicInfo.topicBackgroundColorId)
            topicTitle.setTextColor(context.getColor(topicInfo.topicTitleColorId))
            topicTitle.text = context.getString(topicInfo.topicTitleId)
            topicImage.setImageDrawable(
                AppCompatResources.getDrawable(
                    context, topicInfo.topicImageId
                )
            )
            topicImage.updatePadding(
                top = Utils.convertDpToPixel(topicInfo.imagePaddingTopDp.toFloat(), context).toInt()
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        return TopicViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.topic_viewholder, parent, false)
        )
    }

    override fun getItemCount(): Int = topics.size

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bind(topics[position])
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }
}