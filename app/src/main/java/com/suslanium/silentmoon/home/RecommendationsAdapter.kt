package com.suslanium.silentmoon.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.suslanium.silentmoon.R
import com.suslanium.silentmoon.databinding.HomeListViewholderBinding

class RecommendationsAdapter(
    private val recommendations: List<RecommendationInfo>,
    private val onItemClick: () -> Unit
) : RecyclerView.Adapter<RecommendationsAdapter.RecommendationViewHolder>() {

    private lateinit var context: Context

    inner class RecommendationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = HomeListViewholderBinding.bind(view)

        init {
            binding.root.setOnClickListener {
                onItemClick()
            }
        }

        fun bind(recommendationInfo: RecommendationInfo) = with(binding) {
            homeHolderImage.setImageDrawable(
                AppCompatResources.getDrawable(
                    context, recommendationInfo.imageDrawableId
                )
            )
            homeHolderTitle.setText(recommendationInfo.titleId)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        return RecommendationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.home_list_viewholder, parent, false)
        )
    }

    override fun getItemCount(): Int = recommendations.size

    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        holder.bind(recommendations[position])
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

}