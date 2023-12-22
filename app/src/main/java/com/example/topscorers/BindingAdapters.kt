package com.example.topscorers

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.topscorers.adapters.CountriesAdapter
import com.example.topscorers.dataClasses.country.CountriesDataClass

@BindingAdapter("my_list")
fun bindRecyclerView(recyclerView: RecyclerView, data: CountriesDataClass?) {
    data?.let {
        val adapter = recyclerView.adapter as CountriesAdapter
        adapter.data=data
    }
}