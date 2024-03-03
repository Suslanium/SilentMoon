package com.suslanium.silentmoon.coursedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.suslanium.silentmoon.R
import com.suslanium.silentmoon.databinding.FragmentCourseDetailsBinding

class CourseDetailsFragment : Fragment() {

    private var _binding: FragmentCourseDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseDetailsBinding.inflate(inflater, container, false)
        val tabAdapter = CourseTabAdapter(childFragmentManager, lifecycle)
        binding.viewpager.adapter = tabAdapter
        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            when(position) {
                0 -> {
                    tab.text = requireContext().getString(R.string.male_voice)
                }
                1 -> {
                    tab.text = requireContext().getString(R.string.female_voice)
                }
            }
        }.attach()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}