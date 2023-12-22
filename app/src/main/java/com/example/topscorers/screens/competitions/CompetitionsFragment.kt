package com.example.topscorers.screens.competitions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.topscorers.adapters.LeaguesAdapter
import com.example.topscorers.databinding.FragmentCompetitionsBinding

class CompetitionsFragment : Fragment() {
    private lateinit var binding:FragmentCompetitionsBinding
    private lateinit var viewModel: CompetitionsViewModel
    private val leagueAdapter by lazy { LeaguesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val args=CompetitionsFragmentArgs.fromBundle(requireArguments())

        binding=FragmentCompetitionsBinding.inflate(inflater)
        viewModel=ViewModelProvider(this)[CompetitionsViewModel::class.java]
        binding.leagueList.adapter=leagueAdapter
        viewModel.getLeagues(args.countryId)
        viewModel.leagues.observe(viewLifecycleOwner) { leagues ->
            leagueAdapter.data = leagues
        }

        return binding.root
    }
}