package com.suslanium.silentmoon.meditatev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.suslanium.silentmoon.common.multiselect.MultiSelectAdapter
import com.suslanium.silentmoon.common.multiselect.MultiSelectItems
import com.suslanium.silentmoon.databinding.FragmentMeditateV2Binding

class MeditateV2Fragment : Fragment() {

    private var _binding: FragmentMeditateV2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeditateV2Binding.inflate(inflater, container, false)

        val multiSelectViewManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val multiSelectViewAdapter = MultiSelectAdapter(MultiSelectItems.items)

        binding.meditateV2Multiselect.apply {
            setHasFixedSize(true)
            layoutManager = multiSelectViewManager
            adapter = multiSelectViewAdapter
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}