package com.suslanium.silentmoon.coursedetails.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.suslanium.silentmoon.databinding.FragmentCourseTabBinding
import com.suslanium.silentmoon.utils.InsetListeners

class CourseTabFragment : Fragment() {

    private var _binding: FragmentCourseTabBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseTabBinding.inflate(inflater, container, false)
        val viewManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val viewAdapter = CourseAudioAdapter(CourseAudio.courseAudioInfos, onItemClick = {})
        binding.root.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        ViewCompat.setOnApplyWindowInsetsListener(binding.root, InsetListeners.marginBottomListener)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}