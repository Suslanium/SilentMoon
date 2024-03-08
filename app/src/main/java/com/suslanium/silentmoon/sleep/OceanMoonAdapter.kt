package com.suslanium.silentmoon.sleep

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suslanium.silentmoon.R

class OceanMoonAdapter(private val onCardPress: () -> Unit) : RecyclerView.Adapter<OceanMoonAdapter.OceanMoon>() {

    inner class OceanMoon(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.clipToOutline = true
            view.setOnClickListener { onCardPress() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = OceanMoon(
        LayoutInflater.from(parent.context).inflate(R.layout.ocean_moon_viewholder, parent, false)
    )

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: OceanMoon, position: Int) {}

}