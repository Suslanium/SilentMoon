package com.suslanium.silentmoon.coursedetails.tab

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.suslanium.silentmoon.R
import com.suslanium.silentmoon.databinding.CourseTabViewholderBinding

class CourseAudioAdapter(
    private val courseAudioInfos: List<CourseAudioInfo>,
    private val onItemClick: () -> Unit
) : RecyclerView.Adapter<CourseAudioAdapter.CourseAudioViewHolder>() {

    private lateinit var context: Context

    inner class CourseAudioViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CourseTabViewholderBinding.bind(view)

        init {
            binding.root.setOnClickListener {
                onItemClick()
            }
        }

        fun bind(courseAudioInfo: CourseAudioInfo) = with(binding) {
            playButtonCourse.setImageDrawable(
                AppCompatResources.getDrawable(
                    context,
                    if (courseAudioInfo.isActive) R.drawable.play_selected else R.drawable.play_not_selected
                )
            )
            courseTabHolderTitle.text = context.getString(courseAudioInfo.titleId)
            courseTabHolderDuration.text = context.getString(R.string.min_formattable, courseAudioInfo.duration)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseAudioViewHolder {
        return CourseAudioViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.course_tab_viewholder, parent, false)
        )
    }

    override fun getItemCount(): Int = courseAudioInfos.size

    override fun onBindViewHolder(holder: CourseAudioViewHolder, position: Int) {
        holder.bind(courseAudioInfos[position])
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

}