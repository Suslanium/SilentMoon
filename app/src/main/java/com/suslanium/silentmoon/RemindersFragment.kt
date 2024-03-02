package com.suslanium.silentmoon

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.suslanium.silentmoon.databinding.FragmentRemindersBinding
import com.suslanium.silentmoon.utils.InsetListeners
import com.suslanium.silentmoon.utils.Utils
import com.suslanium.silentmoon.utils.navigateToFragment


class RemindersFragment : Fragment() {

    private var _binding: FragmentRemindersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRemindersBinding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.remindersTitleTime, InsetListeners.marginTopListener)
        ViewCompat.setOnApplyWindowInsetsListener(binding.remindersBottomText, InsetListeners.marginBottomListener)
        binding.saveButton.setOnClickListener {
            parentFragmentManager.navigateToFragment(BottomBarRootFragment::class.java)
        }
        binding.remindersBottomText.setOnClickListener {
            parentFragmentManager.navigateToFragment(BottomBarRootFragment::class.java)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            setTimepickerTextColour(binding.remindersTimePicker)
        }
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("DiscouragedApi")
    private fun setTimepickerTextColour(timePicker: TimePicker) {
        val hourNumberPickerId: Int = resources.getIdentifier("hour", "id", "android")
        val minuteNumberPickerId: Int = resources.getIdentifier("minute", "id", "android")
        val amPmNumberPickerId: Int = resources.getIdentifier("amPm", "id", "android")

        val hourNumberPicker: NumberPicker = timePicker.findViewById(hourNumberPickerId)
        val minuteNumberPicker: NumberPicker = timePicker.findViewById(minuteNumberPickerId)
        val amPmNumberPicker: NumberPicker = timePicker.findViewById(amPmNumberPickerId)

        hourNumberPicker.textColor = requireContext().getColor(R.color.time_picker_selected)
        hourNumberPicker.textSize = Utils.spToPx(24f, requireContext()).toFloat()
        minuteNumberPicker.textColor = requireContext().getColor(R.color.time_picker_selected)
        minuteNumberPicker.textSize = Utils.spToPx(24f, requireContext()).toFloat()
        amPmNumberPicker.textColor = requireContext().getColor(R.color.time_picker_selected)
        amPmNumberPicker.textSize = Utils.spToPx(24f, requireContext()).toFloat()
    }
}