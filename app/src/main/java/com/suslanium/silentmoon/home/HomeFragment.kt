package com.suslanium.silentmoon.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.suslanium.silentmoon.coursedetails.CourseDetailsFragment
import com.suslanium.silentmoon.databinding.FragmentHomeBinding
import com.suslanium.silentmoon.utils.InsetListeners
import com.suslanium.silentmoon.utils.navigateToFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        ViewCompat.setOnApplyWindowInsetsListener(
            binding.logoHome, InsetListeners.marginTopListener
        )
        ViewCompat.setOnApplyWindowInsetsListener(
            binding.silentLogoHome, InsetListeners.marginTopListener
        )
        ViewCompat.setOnApplyWindowInsetsListener(
            binding.moonLogoHome, InsetListeners.marginTopListener
        )

        binding.basicsCard.setOnClickListener {
            parentFragment?.parentFragmentManager?.navigateToFragment(
                CourseDetailsFragment::class.java
            )
        }
        binding.basicsStart.setOnClickListener {
            parentFragment?.parentFragmentManager?.navigateToFragment(
                CourseDetailsFragment::class.java
            )
        }
        binding.relaxationCard.setOnClickListener {
            parentFragment?.parentFragmentManager?.navigateToFragment(
                CourseDetailsFragment::class.java
            )
        }
        binding.relaxationStart.setOnClickListener {
            parentFragment?.parentFragmentManager?.navigateToFragment(
                CourseDetailsFragment::class.java
            )
        }
        binding.thoughtCard.setOnClickListener {
            parentFragment?.parentFragmentManager?.navigateToFragment(
                CourseDetailsFragment::class.java
            )
        }

        val viewManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val viewAdapter = RecommendationsAdapter(Recommendations.recommendationsList) {
            parentFragment?.parentFragmentManager?.navigateToFragment(
                CourseDetailsFragment::class.java
            )
        }
        binding.recommendationsRecycler.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}