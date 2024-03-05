package com.suslanium.silentmoon.common.multiselect

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.suslanium.silentmoon.R
import com.suslanium.silentmoon.databinding.MultiselectViewholderBinding

class MultiSelectAdapter(private val items: List<MultiSelectItemInfo>) :
    RecyclerView.Adapter<MultiSelectAdapter.MultiSelectViewHolder>() {

    private lateinit var context: Context

    private val selectedItems = hashSetOf<Int>()

    inner class MultiSelectViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = MultiselectViewholderBinding.bind(view)
        private var itemIndex: Int = -1

        init {
            binding.multiselectToggle.setOnClickListener {
                if (selectedItems.contains(itemIndex)) {
                    binding.multiselectName.setTextColor(context.getColor(R.color.light_gray))
                    selectedItems.remove(itemIndex)
                } else {
                    binding.multiselectName.setTextColor(context.getColor(R.color.primary_text))
                    selectedItems.add(itemIndex)
                }
            }
        }

        fun bind(multiSelectItemInfo: MultiSelectItemInfo, itemIndex: Int) = with(binding) {
            multiselectName.text = context.getString(multiSelectItemInfo.titleId)
            multiselectToggle.chipIcon = AppCompatResources.getDrawable(
                context, multiSelectItemInfo.iconId
            )

            this@MultiSelectViewHolder.itemIndex = itemIndex
            if (selectedItems.contains(itemIndex)) {
                multiselectName.setTextColor(context.getColor(R.color.primary_text))
                multiselectToggle.isChecked = true
            } else {
                multiselectName.setTextColor(context.getColor(R.color.light_gray))
                multiselectToggle.isChecked = false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MultiSelectViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.multiselect_viewholder, parent, false)
    )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MultiSelectViewHolder, position: Int) = holder.bind(items[position], position)

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

}