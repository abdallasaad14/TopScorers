package com.example.topscorers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.topscorers.R
import com.example.topscorers.dataClasses.country.CountriesDataClass
import com.example.topscorers.dataClasses.leagues.LeaguesDataClass
import com.example.topscorers.databinding.LeaugeItemBinding
import com.example.topscorers.screens.competitions.CompetitionsFragmentDirections
import com.example.topscorers.screens.countries.CountriesFragmentDirections
import com.squareup.picasso.Picasso

class LeaguesAdapter : RecyclerView.Adapter<LeaguesAdapter.MyViewHolder>() {
    var data = LeaguesDataClass()
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
        holder.binding.countryName.text = item.league_name
        if (item.league_logo.isNotEmpty()) {
            Picasso.get().load(item.league_logo).placeholder(R.drawable.baseline_outlined_flag_24)
                .error(R.drawable.baseline_outlined_flag_24).into(holder.binding.countryImg)
        } else {
            Picasso.get().load(R.drawable.baseline_outlined_flag_24).into(holder.binding.countryImg)
        }
        holder.binding.cardId.setOnClickListener { view ->
            view.findNavController().navigate(
                CompetitionsFragmentDirections.actionCompetitionsFragmentToTopScorersFragment(item.league_id)
            )
        }

    }

    override fun getItemCount() = data.size
}