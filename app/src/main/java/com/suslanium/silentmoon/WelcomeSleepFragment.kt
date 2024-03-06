package com.suslanium.silentmoon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import com.suslanium.silentmoon.databinding.FragmentWelcomeSleepBinding
import com.suslanium.silentmoon.utils.InsetListeners

class WelcomeSleepFragment : Fragment() {

    private var _binding: FragmentWelcomeSleepBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeSleepBinding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.welcomeSleepGetStarted, InsetListeners.marginBottomListener)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}