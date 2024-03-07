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