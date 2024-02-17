package com.suslanium.silentmoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.suslanium.silentmoon.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.signUpTopMsg, InsetListeners.topListener)
        ViewCompat.setOnApplyWindowInsetsListener(binding.getStartedSignUpButton, InsetListeners.bottomListener)
        return binding.root
    }
}