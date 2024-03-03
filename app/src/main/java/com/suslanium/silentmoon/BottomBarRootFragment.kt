package com.suslanium.silentmoon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import com.suslanium.silentmoon.databinding.FragmentBottomBarRootBinding
import com.suslanium.silentmoon.utils.InsetListeners

class BottomBarRootFragment : Fragment() {

    private var _binding: FragmentBottomBarRootBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomBarRootBinding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.bottomBar, InsetListeners.marginBottomListener)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}