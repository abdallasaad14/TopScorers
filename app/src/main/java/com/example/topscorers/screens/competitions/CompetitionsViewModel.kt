package com.example.topscorers.screens.competitions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.topscorers.api.ApiClient
import com.example.topscorers.api.ApiService
import com.example.topscorers.dataClasses.country.CountriesDataClass
import com.example.topscorers.dataClasses.leagues.LeaguesDataClass
import com.example.topscorers.utils.Constants
import kotlinx.coroutines.launch

class CompetitionsViewModel:ViewModel() {
    private val api: ApiService by lazy { ApiClient().getClient().create(ApiService::class.java) }

    private val _leagues = MutableLiveData<LeaguesDataClass>()

    // The external immutable LiveData for the request status String
    val leagues: LiveData<LeaguesDataClass>
        get() = _leagues


     fun getLeagues(countryId:String) {
        viewModelScope.launch {
            val callCountryApi = api.getLeague(countryID = countryId)
            try {
                val listResult =callCountryApi.await()
                _leagues.value=listResult
            } catch (e: Exception) {
            }
        }

    }

}