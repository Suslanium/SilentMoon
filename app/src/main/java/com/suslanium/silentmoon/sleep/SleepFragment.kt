package com.suslanium.silentmoon.sleep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.LinearLayoutManager
import com.suslanium.silentmoon.PlayOptionFragment
import com.suslanium.silentmoon.R
import com.suslanium.silentmoon.SleepMusicFragment
import com.suslanium.silentmoon.common.multiselect.MultiSelectAdapter
import com.suslanium.silentmoon.common.multiselect.MultiSelectItems
import com.suslanium.silentmoon.common.sleepmusic.SleepMusic
import com.suslanium.silentmoon.common.sleepmusic.SleepMusicAdapter
import com.suslanium.silentmoon.databinding.FragmentSleepBinding
import com.suslanium.silentmoon.utils.navigateToFragment
import com.suslanium.silentmoon.utils.navigateToFragmentBottomBar

class SleepFragment : Fragment() {

    private var _binding: FragmentSleepBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSleepBinding.inflate(inflater, container, false)

        val multiSelectViewManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val multiSelectViewAdapter = MultiSelectAdapter(
            items = MultiSelectItems.items,
            activeHolderTextColor = R.color.very_light_gray_variant,
            inactiveTextColor = R.color.sleep_secondary_text,
            chipIconColor = R.color.very_light_gray_variant,
            chipBackgroundColorList = R.color.sleep_multiselect_bg
        )

        binding.sleepMultiselect.apply {
            setHasFixedSize(true)
            layoutManager = multiSelectViewManager
            adapter = multiSelectViewAdapter
        }

        val viewManager = GridLayoutManager(requireContext(), 2)
        viewManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (position == 0) return 2
                return 1
            }
        }

        val viewAdapter = SleepMusicAdapter(SleepMusic.list) {
            parentFragment?.parentFragmentManager?.navigateToFragment(PlayOptionFragment::class.java)
        }

        binding.sleepRecycler.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = ConcatAdapter(
                OceanMoonAdapter(onCardPress = {
                    parentFragmentManager.navigateToFragmentBottomBar(SleepMusicFragment::class.java)
                }), viewAdapter
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}