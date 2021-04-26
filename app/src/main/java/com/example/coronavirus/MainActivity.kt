package com.example.coronavirus

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.coronavirus.data.CoronaList
import com.example.coronavirus.data.Regions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = ApiClient.retrofitInstance?.create(ApiService::class.java)
        val call = service?.getCountries()


        call?.enqueue(object : Callback<CoronaList> {
            override fun onResponse(call: Call<CoronaList>, response: Response<CoronaList>) {
                /*if (response.code() == 200) {
                    val regionsResponse = response.body()!!
                    Log.v("Regions", regionsResponse.toString())

                }*/
            }
            override fun onFailure(call: Call<CoronaList>, t: Throwable) {
                Log.v("FailCode",t.toString())

            }
        })
    }

}