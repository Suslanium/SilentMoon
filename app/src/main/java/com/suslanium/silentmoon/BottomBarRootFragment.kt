package com.suslanium.silentmoon

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
            handleFragmentChange(fragment) {
                itemChangedProgrammatically = true
            }
        }

        childFragmentManager.addOnBackStackChangedListener {
            val currentFragment = childFragmentManager.fragments.last()
            handleFragmentChange(currentFragment) {
                itemChangedProgrammatically = true
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        backCallback = requireActivity().onBackPressedDispatcher.addCallback {
            if (childFragmentManager.backStackEntryCount > 0)
                childFragmentManager.popBackStack()
            else
                activity?.finish()
        }
    }

    override fun onPause() {
        super.onPause()
        itemChangedProgrammatically = false
        backCallback.remove()
    }

    private fun handleFragmentChange(
        fragment: Fragment,
        onSelectedItemChanged: () -> Unit
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

            is ProfileFragment -> {
                onSelectedItemChanged()
                binding.bottomBar.selectedItemId = R.id.menu_profile
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}