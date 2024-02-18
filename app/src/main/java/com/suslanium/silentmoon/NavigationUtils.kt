package com.suslanium.silentmoon

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun FragmentManager.navigateToFragment(fragment: Class<out Fragment>, fragmentContainerViewId: Int = R.id.fragmentContainerView) = this.beginTransaction()
    .setReorderingAllowed(true).setCustomAnimations(
        R.anim.fragment_open_enter,
        R.anim.fragment_close_exit,
        R.anim.fragment_open_enter,
        R.anim.fragment_close_exit
    ).add(fragmentContainerViewId, fragment, null)
    .addToBackStack(null).commit()