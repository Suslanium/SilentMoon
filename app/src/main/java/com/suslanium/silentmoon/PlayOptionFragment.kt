package com.suslanium.silentmoon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.suslanium.silentmoon.common.sleepmusic.SleepMusic
import com.suslanium.silentmoon.common.sleepmusic.SleepMusicAdapter
import com.suslanium.silentmoon.databinding.FragmentPlayOptionBinding
import com.suslanium.silentmoon.utils.InsetListeners
import com.suslanium.silentmoon.utils.navigateToFragment

class PlayOptionFragment : Fragment() {

    private var _binding: FragmentPlayOptionBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayOptionBinding.inflate(inflater, container, false)

        ViewCompat.setOnApplyWindowInsetsListener(binding.playOptionRecycler, InsetListeners.marginBottomListener)
        ViewCompat.setOnApplyWindowInsetsListener(binding.playOptionBottomNavbarMargin, InsetListeners.heightBottomListener)

        val viewManager = GridLayoutManager(requireContext(), 2)
        val viewAdapter = SleepMusicAdapter(SleepMusic.list) {}

        binding.playOptionRecycler.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        binding.playOptionButton.setOnClickListener {
            parentFragmentManager.navigateToFragment(MusicFragment::class.java)
        }

        binding.backFabPlayOption.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}