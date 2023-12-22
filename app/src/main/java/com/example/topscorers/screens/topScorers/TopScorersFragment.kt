package com.example.topscorers.screens.topScorers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.topscorers.R
import com.example.topscorers.adapters.TopScorersAdapter
import com.example.topscorers.databinding.FragmentTopScorersBinding
import com.example.topscorers.databinding.TopScorerItemBinding
import com.example.topscorers.screens.competitions.CompetitionsFragmentArgs
import com.example.topscorers.screens.competitions.CompetitionsViewModel

class TopScorersFragment : Fragment() {
    lateinit var binding: FragmentTopScorersBinding
    lateinit var viewModel:TopScorersViewModel
    val topScorerAdapter by lazy { TopScorersAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args= TopScorersFragmentArgs.fromBundle(requireArguments())

        binding= FragmentTopScorersBinding.inflate(inflater)
        viewModel= ViewModelProvider(this)[TopScorersViewModel::class.java]
        binding.topScorerList.adapter=topScorerAdapter
        viewModel.getTopScorers(args.leagueId)
        viewModel.topScorer.observe(viewLifecycleOwner) { topScorers ->
            topScorerAdapter.data = topScorers
        }

        return binding.root
    }
}