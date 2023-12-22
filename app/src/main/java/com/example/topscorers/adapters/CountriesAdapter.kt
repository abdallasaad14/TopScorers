package com.example.topscorers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.topscorers.R
import com.example.topscorers.dataClasses.country.CountriesDataClass
import com.example.topscorers.databinding.LeaugeItemBinding
import com.example.topscorers.screens.countries.CountriesFragmentDirections
import com.squareup.picasso.Picasso

class CountriesAdapter : RecyclerView.Adapter<CountriesAdapter.MyViewHolder>() {
    var data = CountriesDataClass()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class MyViewHolder(val binding: LeaugeItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(
            LeaugeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        holder.binding.countryName.text = item.country_name
        if (item.country_logo.isNotEmpty()) {
            Picasso.get().load(item.country_logo).placeholder(R.drawable.baseline_outlined_flag_24)
                .error(R.drawable.baseline_outlined_flag_24).into(holder.binding.countryImg)
        } else {
            Picasso.get().load(R.drawable.baseline_outlined_flag_24).into(holder.binding.countryImg)
        }
        holder.binding.cardId.setOnClickListener { view->
            view.findNavController().navigate(CountriesFragmentDirections.actionCountriesFragmentToCompetitionsFragment(item.country_id))
        }

    }

    override fun getItemCount() = data.size
}