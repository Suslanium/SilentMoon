package com.suslanium.silentmoon.common.sleepmusic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.suslanium.silentmoon.R
import com.suslanium.silentmoon.databinding.SleepMusicViewholderBinding

class SleepMusicAdapter(private val items: List<SleepMusicInfo>, private val onClick: () -> Unit) :
    RecyclerView.Adapter<SleepMusicAdapter.SleepMusicViewHolder>() {

    private lateinit var context: Context

    inner class SleepMusicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = SleepMusicViewholderBinding.bind(view)

        init {
            binding.sleepHolderImage.clipToOutline = true
            binding.root.setOnClickListener {
                onClick()
            }
        }

        fun bind(itemInfo: SleepMusicInfo) = with(binding) {
            sleepHolderImage.setImageDrawable(
                AppCompatResources.getDrawable(
                    context, itemInfo.imageId
                )
            )

            sleepHolderTitle.text = context.getString(itemInfo.titleId)

            sleepHolderDuration.text = context.getString(R.string.min_formattable, itemInfo.duration)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SleepMusicViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.sleep_music_viewholder, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SleepMusicViewHolder, position: Int) = holder.bind(items[position])

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

}