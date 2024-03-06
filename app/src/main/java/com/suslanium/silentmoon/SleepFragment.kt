package com.suslanium.silentmoon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.suslanium.silentmoon.common.multiselect.MultiSelectAdapter
import com.suslanium.silentmoon.common.multiselect.MultiSelectItems
import com.suslanium.silentmoon.databinding.FragmentSleepBinding

class SleepFragment : Fragment() {

    private var _binding: FragmentSleepBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSleepBinding.inflate(inflater, container, false)

        val multiSelectViewManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val multiSelectViewAdapter = MultiSelectAdapter(
            items = MultiSelectItems.items,
            activeHolderTextColor = R.color.very_light_gray_variant,
            inactiveTextColor = R.color.sleep_multiselect_inactive_text,
            chipIconColor = R.color.very_light_gray_variant,
            chipBackgroundColorList = R.color.sleep_multiselect_bg)

        binding.sleepMultiselect.apply {
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