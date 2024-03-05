package com.suslanium.silentmoon.choosetopic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.suslanium.silentmoon.R
import com.suslanium.silentmoon.databinding.TopicViewholderBinding
import com.suslanium.silentmoon.utils.Utils


class TopicAdapter(private val topics: List<TopicInfo>, private val onItemClick: () -> Unit) :
    RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    private lateinit var context: Context

    inner class TopicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = TopicViewholderBinding.bind(view)

        init {
            binding.root.setOnClickListener {
                onItemClick()
            }
        }

        fun bind(topicInfo: TopicInfo) = with(binding) {
            val layoutParams = root.layoutParams as StaggeredGridLayoutManager.LayoutParams
            layoutParams.height = if (topicInfo.isSmall) context.resources.getDimensionPixelSize(R.dimen.item_small_height) else context.resources.getDimensionPixelSize(
                R.dimen.item_height
            )
            root.backgroundTintList = context.getColorStateList(topicInfo.topicBackgroundColorId)
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