package com.suslanium.silentmoon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import com.suslanium.silentmoon.databinding.FragmentSignUpSignInBinding

class SignUpSignInFragment : Fragment() {

    private var _binding: FragmentSignUpSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpSignInBinding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.logo, InsetListeners.topListener)
        ViewCompat.setOnApplyWindowInsetsListener(binding.silentLogo, InsetListeners.topListener)
        ViewCompat.setOnApplyWindowInsetsListener(binding.moonLogo, InsetListeners.topListener)
        ViewCompat.setOnApplyWindowInsetsListener(binding.signUpSignInBottomText, InsetListeners.bottomListener)
        return binding.root
    }
}