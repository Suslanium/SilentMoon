package com.suslanium.silentmoon.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.suslanium.silentmoon.R

fun FragmentManager.navigateToFragment(fragment: Class<out Fragment>, fragmentContainerViewId: Int = R.id.fragmentContainerView) = this.beginTransaction()
    .setReorderingAllowed(true).setCustomAnimations(
        R.anim.fragment_open_enter,
        R.anim.still_close,
        R.anim.none,
        R.anim.fragment_close_exit
    ).replace(fragmentContainerViewId, fragment, null)
    .addToBackStack(null).commit()

fun FragmentManager.navigateToFragmentBottomBar(fragment: Class<out Fragment>, fragmentContainerViewId: Int = R.id.navigation_fragment_root) = this.beginTransaction()
    .setReorderingAllowed(true).setCustomAnimations(
        com.google.android.material.R.anim.abc_fade_in,
        com.google.android.material.R.anim.abc_fade_out,
        com.google.android.material.R.anim.abc_fade_in,
        com.google.android.material.R.anim.abc_fade_out,
    ).replace(fragmentContainerViewId, fragment, null)
    .addToBackStack(null).commit()