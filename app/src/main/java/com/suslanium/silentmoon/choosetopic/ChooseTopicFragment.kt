package com.suslanium.silentmoon.choosetopic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.suslanium.silentmoon.RemindersFragment
import com.suslanium.silentmoon.databinding.FragmentChooseTopicBinding
import com.suslanium.silentmoon.utils.InsetListeners
import com.suslanium.silentmoon.utils.navigateToFragment


class ChooseTopicFragment : Fragment() {

    private var _binding: FragmentChooseTopicBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseTopicBinding.inflate(inflater, container, false)
        ViewCompat.setOnApplyWindowInsetsListener(binding.chooseTopicTitle, InsetListeners.marginTopListener)
        val viewManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val viewAdapter = TopicAdapter(Topics.topicList, onItemClick = {
            parentFragmentManager.navigateToFragment(RemindersFragment::class.java)
        })
        binding.chooseTopicRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        return binding.root
    }
}