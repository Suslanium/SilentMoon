package com.suslanium.silentmoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.suslanium.silentmoon.common.sleepmusic.SleepMusic
import com.suslanium.silentmoon.common.sleepmusic.SleepMusicAdapter
import com.suslanium.silentmoon.databinding.FragmentSleepMusicBinding
import com.suslanium.silentmoon.utils.navigateToFragment

class SleepMusicFragment : Fragment() {

    private var _binding: FragmentSleepMusicBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSleepMusicBinding.inflate(inflater, container, false)

        val viewManager = GridLayoutManager(requireContext(), 2)
        val viewAdapter = SleepMusicAdapter(SleepMusic.list) {
            parentFragment?.parentFragmentManager?.navigateToFragment(PlayOptionFragment::class.java)
        }

        binding.sleepMusicRecycler.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        binding.backFabSleepMusic.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}