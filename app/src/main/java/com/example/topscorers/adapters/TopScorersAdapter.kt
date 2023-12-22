package com.example.topscorers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.topscorers.dataClasses.leagues.LeaguesDataClass
import com.example.topscorers.dataClasses.topScorers.TopScorersDataClass
import com.example.topscorers.databinding.TopScorerItemBinding

class TopScorersAdapter : RecyclerView.Adapter<TopScorersAdapter.MyViewHolder>() {

    var data = TopScorersDataClass()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopScorersAdapter.MyViewHolder {
        return MyViewHolder(
            TopScorerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class MyViewHolder(val binding: TopScorerItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: TopScorersAdapter.MyViewHolder, position: Int) {
        val item=data[position]
        holder.binding.playerName.text=item.player_name
        holder.binding.playerTeam.text=item.team_name
        holder.binding.playerGoals.text=item.goals+" G "
        holder.binding.playerAssists.text=item.assists+" A "
        holder.binding.playerPenaltyGoals.text=item.penalty_goals+ " P "
        holder.binding.playerPlace.text="${item.player_place} - "
    }

    override fun getItemCount()=data.size
}