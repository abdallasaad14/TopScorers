package com.example.topscorers.screens.countries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.topscorers.adapters.CountriesAdapter
import com.example.topscorers.databinding.FragmentCountriesBinding

class CountriesFragment : Fragment() {
    lateinit var binding: FragmentCountriesBinding
    lateinit var viewModel: CountriesViewModel
    private val countryAdapter by lazy { CountriesAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCountriesBinding.inflate(inflater)
        binding.countryList.adapter = countryAdapter
        viewModel=ViewModelProvider(this)[CountriesViewModel::class.java]
        binding.viewModel=viewModel
        binding.lifecycleOwner=this

        return binding.root
    }
}