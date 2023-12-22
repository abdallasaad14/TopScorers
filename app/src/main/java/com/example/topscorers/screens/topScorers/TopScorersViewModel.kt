package com.example.topscorers.screens.topScorers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.topscorers.api.ApiClient
import com.example.topscorers.api.ApiService
import com.example.topscorers.dataClasses.topScorers.TopScorersDataClass
import kotlinx.coroutines.launch

class TopScorersViewModel:ViewModel() {
    private val api: ApiService by lazy { ApiClient().getClient().create(ApiService::class.java) }

    private val _topScorers = MutableLiveData<TopScorersDataClass>()

    // The external immutable LiveData for the request status String
    val topScorer: LiveData<TopScorersDataClass>
        get() = _topScorers

    fun getTopScorers(leagueId:String) {
        viewModelScope.launch {
            val callTopScorersApi = api.getTopScorer(leagueId= leagueId)
            try {
                val listResult =callTopScorersApi.await()
                _topScorers.value=listResult
            } catch (e: Exception) {
            }
        }

    }


}