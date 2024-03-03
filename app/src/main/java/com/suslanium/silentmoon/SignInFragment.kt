package com.suslanium.silentmoon

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.suslanium.silentmoon.databinding.FragmentSignInBinding
import com.suslanium.silentmoon.utils.InsetListeners
import com.suslanium.silentmoon.utils.navigateToFragment

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.signInTopMsg, InsetListeners.marginTopListener)
        ViewCompat.setOnApplyWindowInsetsListener(binding.signInBottomText, InsetListeners.marginBottomListener)

        binding.logInButton.setOnClickListener {
            parentFragmentManager.navigateToFragment(WelcomeFragment::class.java)
        }

        val nonClickableStringPart = ContextCompat.getString(requireContext(), R.string.log_in_bottom_text_part)
        val clickableStringPart = ContextCompat.getString(requireContext(), R.string.log_in_bottom_text_clickable_part)
        val spannableString = SpannableString("$nonClickableStringPart $clickableStringPart")
        val clickableSpan = object : ClickableSpan() {
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
                ds.color = ContextCompat.getColor(requireContext(), R.color.light_blue)
            }

            override fun onClick(p0: View) {
                parentFragmentManager.navigateToFragment(SignUpFragment::class.java)
            }
        }
        spannableString.setSpan(clickableSpan, spannableString.length-clickableStringPart.length, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.signInBottomText.text = spannableString
        binding.signInBottomText.movementMethod = LinkMovementMethod.getInstance()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}