package com.suslanium.silentmoon.meditatev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.suslanium.silentmoon.common.multiselect.MultiSelectAdapter
import com.suslanium.silentmoon.common.multiselect.MultiSelectItems
import com.suslanium.silentmoon.coursedetails.CourseDetailsFragment
import com.suslanium.silentmoon.databinding.FragmentMeditateV2Binding
import com.suslanium.silentmoon.utils.navigateToFragment

class MeditateV2Fragment : Fragment() {

    private var _binding: FragmentMeditateV2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeditateV2Binding.inflate(inflater, container, false)

        val multiSelectViewManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val multiSelectViewAdapter = MultiSelectAdapter(MultiSelectItems.items)

        binding.meditateV2Multiselect.apply {
            setHasFixedSize(true)
            layoutManager = multiSelectViewManager
            adapter = multiSelectViewAdapter
        }

        val meditationViewManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val meditationViewAdapter = MeditationAdapter(Meditations.list)

        binding.meditateV2Recycler.apply {
            setHasFixedSize(true)
            layoutManager = meditationViewManager
            adapter = ConcatAdapter(MeditationHeaderAdapter(onHeaderClick = {
                parentFragment?.parentFragmentManager?.navigateToFragment(CourseDetailsFragment::class.java)
            }), meditationViewAdapter)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}