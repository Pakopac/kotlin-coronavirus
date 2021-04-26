package com.example.coronavirus

import com.example.coronavirus.data.CoronaList
import com.example.coronavirus.data.coronaList
import retrofit2.http.*
import retrofit2.Call

interface ApiService {

    @GET("/")
    fun getCountries(): Call<coronaList>
}