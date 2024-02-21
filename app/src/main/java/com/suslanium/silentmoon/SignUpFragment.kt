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
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.suslanium.silentmoon.databinding.FragmentSignUpBinding
import com.suslanium.silentmoon.utils.InsetListeners
import com.suslanium.silentmoon.utils.navigateToFragment

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.signUpTopMsg, InsetListeners.marginTopListener)
        ViewCompat.setOnApplyWindowInsetsListener(binding.getStartedSignUpButton, InsetListeners.marginBottomListener)

        binding.getStartedSignUpButton.setOnClickListener {
            parentFragmentManager.navigateToFragment(WelcomeFragment::class.java)
        }

        val nonClickableStringPart = ContextCompat.getString(requireContext(), R.string.privacy_policy_confirmation_part)
        val clickableStringPart = ContextCompat.getString(requireContext(), R.string.privacy_policy_confirmation_clickable_part)
        val spannableString = SpannableString("$nonClickableStringPart $clickableStringPart")
        val clickableSpan = object : ClickableSpan() {
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
                ds.color = ContextCompat.getColor(requireContext(), R.color.facebook)
            }

            override fun onClick(p0: View) {
                Toast.makeText(requireContext(), ContextCompat.getString(requireContext(), R.string.privacy_policy_stub), Toast.LENGTH_LONG).show()
            }
        }
        spannableString.setSpan(clickableSpan, spannableString.length-clickableStringPart.length, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.privacyPolicyText.text = spannableString
        binding.privacyPolicyText.movementMethod = LinkMovementMethod.getInstance()
        return binding.root
    }
}