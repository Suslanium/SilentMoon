package com.suslanium.silentmoon

import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.suslanium.silentmoon.databinding.FragmentBottomBarRootBinding
import com.suslanium.silentmoon.home.HomeFragment
import com.suslanium.silentmoon.meditatev2.MeditateV2Fragment
import com.suslanium.silentmoon.sleep.SleepFragment
import com.suslanium.silentmoon.utils.InsetListeners
import com.suslanium.silentmoon.utils.navigateToFragment
import com.suslanium.silentmoon.utils.navigateToFragmentBottomBar

class BottomBarRootFragment : Fragment() {

    private var _binding: FragmentBottomBarRootBinding? = null

    private val binding get() = _binding!!

    private lateinit var backCallback: OnBackPressedCallback

    private var itemChangedProgrammatically = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomBarRootBinding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(
            binding.bottomBar, InsetListeners.marginBottomListener
        )

        binding.bottomBar.setOnItemSelectedListener {
            if (itemChangedProgrammatically) {
                itemChangedProgrammatically = false
                return@setOnItemSelectedListener true
            }
            if (it.itemId == binding.bottomBar.selectedItemId) return@setOnItemSelectedListener false
            when (it.itemId) {
                R.id.menu_home -> childFragmentManager.navigateToFragmentBottomBar(HomeFragment::class.java)

                R.id.menu_sleep -> {
                    parentFragmentManager.navigateToFragment(WelcomeSleepFragment::class.java)
                    childFragmentManager.navigateToFragmentBottomBar(SleepFragment::class.java)
                }

                R.id.menu_meditate -> childFragmentManager.navigateToFragmentBottomBar(
                    MeditateV2Fragment::class.java
                )

                R.id.menu_music -> parentFragmentManager.navigateToFragment(MusicV2Fragment::class.java)

                R.id.menu_profile -> childFragmentManager.navigateToFragmentBottomBar(
                    ProfileFragment::class.java
                )
            }
            return@setOnItemSelectedListener false
        }

        childFragmentManager.addFragmentOnAttachListener { _, fragment ->
            determineTheme(fragment, false)
            handleFragmentChange(fragment) {
                itemChangedProgrammatically = true
            }
        }

        childFragmentManager.addOnBackStackChangedListener {
            val currentFragment = childFragmentManager.fragments.last()
            determineTheme(currentFragment, false)
            handleFragmentChange(currentFragment) {
                itemChangedProgrammatically = true
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        determineTheme(childFragmentManager.fragments.last(), true)
        backCallback = requireActivity().onBackPressedDispatcher.addCallback {
            if (childFragmentManager.backStackEntryCount > 0) childFragmentManager.popBackStack()
            else activity?.finish()
        }
    }

    override fun onPause() {
        super.onPause()
        itemChangedProgrammatically = false
        backCallback.remove()
    }

    private fun handleFragmentChange(
        fragment: Fragment, onSelectedItemChanged: () -> Unit
    ) {
        when (fragment) {
            is HomeFragment -> {
                onSelectedItemChanged()
                binding.bottomBar.selectedItemId = R.id.menu_home
            }

            is MeditateV2Fragment -> {
                onSelectedItemChanged()
                binding.bottomBar.selectedItemId = R.id.menu_meditate
            }

            is SleepFragment -> {
                onSelectedItemChanged()
                binding.bottomBar.selectedItemId = R.id.menu_sleep
            }

            is SleepMusicFragment -> {
                onSelectedItemChanged()
                binding.bottomBar.selectedItemId = R.id.menu_sleep
            }

            is ProfileFragment -> {
                onSelectedItemChanged()
                binding.bottomBar.selectedItemId = R.id.menu_profile
            }
        }
    }

    private fun determineTheme(
        fragment: Fragment, immediateTransition: Boolean
    ) {
        when (fragment) {
            is HomeFragment -> setTheme(
                dark = false, immediateTransition = immediateTransition
            )

            is MeditateV2Fragment -> setTheme(
                dark = false, immediateTransition = immediateTransition
            )

            is SleepFragment -> setTheme(
                dark = true, immediateTransition = immediateTransition
            )

            is SleepMusicFragment -> setTheme(
                dark = true, immediateTransition = immediateTransition
            )

            is ProfileFragment -> setTheme(
                dark = false, immediateTransition = immediateTransition
            )
        }
    }

    private fun setTheme(dark: Boolean, immediateTransition: Boolean) {
        val animationStartColor =
            (binding.bottomBar.background as? ColorDrawable)?.color ?: Color.WHITE
        if (dark) {
            binding.bottomBar.itemTextColor =
                requireContext().getColorStateList(R.color.bottom_bar_text_color_dark)
            binding.bottomBar.itemIconTintList =
                requireContext().getColorStateList(R.color.bottom_bar_icon_color_dark)

            val animationEndColor = requireContext().getColor(R.color.sleep_bg)

            if (!immediateTransition) animateThemeColorChange(animationStartColor, animationEndColor)
            else changeThemeColorImmediately(animationEndColor)
        } else {
            binding.bottomBar.itemTextColor =
                requireContext().getColorStateList(R.color.bottom_bar_text_color)
            binding.bottomBar.itemIconTintList =
                requireContext().getColorStateList(R.color.bottom_bar_icon_color)

            val animationEndColor = requireContext().getColor(R.color.white)

            if (!immediateTransition) animateThemeColorChange(animationStartColor, animationEndColor)
            else changeThemeColorImmediately(animationEndColor)
        }
    }

    private fun changeThemeColorImmediately(color: Int) {
        binding.navigationFragmentRoot.setBackgroundColor(color)
        binding.bottomBar.setBackgroundColor(color)
        binding.root.setBackgroundColor(color)
    }

    private fun animateThemeColorChange(startColor: Int, endColor: Int) {
        val colorAnimation = ValueAnimator.ofArgb(startColor, endColor)
        colorAnimation.setDuration(300)
        colorAnimation.addUpdateListener {
            binding.navigationFragmentRoot.setBackgroundColor(it.animatedValue as Int)
            binding.bottomBar.setBackgroundColor(it.animatedValue as Int)
            binding.root.setBackgroundColor(it.animatedValue as Int)
        }
        colorAnimation.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}