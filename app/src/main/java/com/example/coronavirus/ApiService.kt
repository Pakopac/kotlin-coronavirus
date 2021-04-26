package com.example.coronavirus

import com.example.coronavirus.data.CoronaList
import retrofit2.http.*
import retrofit2.Call

interface ApiService {

    @GET("/")
    fun getCountries(): Call<CoronaList>
}