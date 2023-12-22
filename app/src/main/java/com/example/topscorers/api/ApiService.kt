package com.example.topscorers.api

import com.example.topscorers.dataClasses.country.CountriesDataClass
import com.example.topscorers.dataClasses.leagues.LeaguesDataClass
import com.example.topscorers.dataClasses.topScorers.TopScorersDataClass
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/?")
    fun getCountries(@Query("action") action: String = "get_countries"): Deferred<CountriesDataClass>

    @GET("/?")
    fun getLeague(
        @Query("action")action:String= "get_leagues",
        @Query("country_id") countryID: String
    ): Deferred<LeaguesDataClass>

    @GET("/?")
    fun getTopScorer(
        @Query("action")action:String= "get_topscorers",
        @Query("league_id") leagueId: String
    ): Deferred<TopScorersDataClass>

}