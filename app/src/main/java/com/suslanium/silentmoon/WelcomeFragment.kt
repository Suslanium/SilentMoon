package com.suslanium.silentmoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.suslanium.silentmoon.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.logoWelcome, InsetListeners.marginTopListener)
        ViewCompat.setOnApplyWindowInsetsListener(binding.silentLogoWelcome, InsetListeners.marginTopListener)
        ViewCompat.setOnApplyWindowInsetsListener(binding.moonLogoWelcome, InsetListeners.marginTopListener)
        ViewCompat.setOnApplyWindowInsetsListener(
            binding.welcomeBottomInset,
            InsetListeners.heightBottomListener
        )
        return binding.root
    }
}