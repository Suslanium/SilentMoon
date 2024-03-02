package com.suslanium.silentmoon.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.suslanium.silentmoon.databinding.FragmentHomeBinding
import com.suslanium.silentmoon.utils.InsetListeners

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.logoHome, InsetListeners.marginTopListener)
        ViewCompat.setOnApplyWindowInsetsListener(binding.silentLogoHome, InsetListeners.marginTopListener)
        ViewCompat.setOnApplyWindowInsetsListener(binding.moonLogoHome, InsetListeners.marginTopListener)
        val viewManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val viewAdapter = RecommendationsAdapter(Recommendations.recommendationsList, {})
        binding.recommendationsRecycler.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        return binding.root
    }
}