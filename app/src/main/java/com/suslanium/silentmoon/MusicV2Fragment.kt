package com.suslanium.silentmoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.suslanium.silentmoon.databinding.FragmentMusicV2Binding
import com.suslanium.silentmoon.utils.InsetListeners

class MusicV2Fragment : Fragment() {

    private var _binding: FragmentMusicV2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMusicV2Binding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.musicV2Current, InsetListeners.marginBottomListener)
        ViewCompat.setOnApplyWindowInsetsListener(binding.musicV2Duration, InsetListeners.marginBottomListener)
        binding.musicV2Close.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}