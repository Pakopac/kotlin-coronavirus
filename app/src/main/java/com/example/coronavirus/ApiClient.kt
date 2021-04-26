package com.example.coronavirus

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private const val BASE_URL = "https://api.quarantine.country/api/v1/summary/latest/"

    private val okHttpClient = OkHttpClient()
            .newBuilder()
            .build()

    val apiService: ApiService by lazy {
        val retrofit: Retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return@lazy retrofit.create(ApiService::class.java)
    }
}
