package com.suslanium.silentmoon.meditatev2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.suslanium.silentmoon.R

class MeditationHeaderAdapter : RecyclerView.Adapter<MeditationHeaderAdapter.MeditationHeader>() {

    inner class MeditationHeader(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MeditationHeader(
        LayoutInflater.from(parent.context).inflate(R.layout.daily_calm_card, parent, false)
    )

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: MeditationHeader, position: Int) {
        val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
        layoutParams.isFullSpan = true
    }

}