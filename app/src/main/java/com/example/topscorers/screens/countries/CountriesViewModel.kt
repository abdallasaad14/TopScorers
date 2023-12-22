package com.example.topscorers.screens.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.topscorers.api.ApiClient
import com.example.topscorers.api.ApiService
import com.example.topscorers.dataClasses.country.CountriesDataClass
import com.example.topscorers.utils.Constants.MAIN_COUNTRIES
import kotlinx.coroutines.launch

class CountriesViewModel : ViewModel() {
    private val api: ApiService by lazy { ApiClient().getClient().create(ApiService::class.java) }

    private val _countries = MutableLiveData<CountriesDataClass>()

    // The external immutable LiveData for the request status String
    val countries: LiveData<CountriesDataClass>
        get() = _countries

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            val callCountryApi = api.getCountries()
            try {
                val listResult = CountriesDataClass()
                for (i in callCountryApi.await()) {
                    if (i.country_name in MAIN_COUNTRIES) {
                        listResult.add(i)
                    }
                }
                _countries.value=listResult
            } catch (e: Exception) {
            }
        }

    }
}