package com.example.coronavirus

import retrofit2.Response
import retrofit2.http.*
import com.example.coronavirus.models.Country
import retrofit2.Call

interface ApiService {

    @GET("/")
    fun getCountries(): Call<List<Country>>
}