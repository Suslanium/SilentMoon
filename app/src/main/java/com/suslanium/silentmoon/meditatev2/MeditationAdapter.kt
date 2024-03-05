package com.suslanium.silentmoon.meditatev2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.suslanium.silentmoon.R
import com.suslanium.silentmoon.databinding.MeditateV2ViewholderBinding

class MeditationAdapter(private val items: List<MeditationInfo>) :
    RecyclerView.Adapter<MeditationAdapter.MeditationViewHolder>() {

    private lateinit var context: Context

    inner class MeditationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = MeditateV2ViewholderBinding.bind(view)

        init {
            binding.root.clipToOutline = true
        }

        fun bind(meditationInfo: MeditationInfo) = with(binding) {
            root.layoutParams.height =
                if (meditationInfo.isTallItem) context.resources.getDimensionPixelSize(
                    R.dimen.item_height
                ) else context.resources.getDimensionPixelSize(
                    R.dimen.item_small_height
                )

            meditateV2HolderBackground.setImageDrawable(
                AppCompatResources.getDrawable(
                    context, meditationInfo.backgroundId
                )
            )

            meditateV2HolderBlur.setImageDrawable(
                AppCompatResources.getDrawable(
                    context, meditationInfo.blurId
                )
            )

            meditateV2HolderTitle.text = context.getString(meditationInfo.titleId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MeditationViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.meditate_v2_viewholder, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MeditationViewHolder, position: Int) =
        holder.bind(items[position])

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

}