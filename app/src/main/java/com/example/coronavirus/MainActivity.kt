package com.example.coronavirus

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coronavirus.adapter.CountryListAdapter
import com.example.coronavirus.data.CoronaList
import com.example.coronavirus.databinding.ActivityMainBinding
import com.example.coronavirus.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await


class MainActivity : AppCompatActivity() {
    lateinit var rv_countries: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val service = ApiClient.retrofitInstance?.create(ApiService::class.java)
        val call = service?.getCountries()*/


        val tsdbService = ApiClient.apiService
        GlobalScope.launch(Dispatchers.Main) {
            val allIdRequests = tsdbService.getCountries()
            try {
                val response = allIdRequests.await()
                val regions = response.regions
                //Log.v("regions",regions.toString())
                withContext(Dispatchers.Main){

                    Log.v("regions",regions.toString())


                    ViewModel.searchRequestSuccess.observe(viewLifecycleOwner, { searchResult ->
                        binding.lottiePlant.isVisible = false
                        adapter.submitList(regions)
                    })


                    val adapter = CountryListAdapter()
                    binding.rvCountries.adapter = adapter
                }
                //getHasil(tsdbResponse?.leagues!!)
                //val adapater = CountryListAdapter(regions!!)


            } catch (e: Exception) {
                Log.v("errorRegions", e.toString())
            }
        }


        /*call?.enqueue(object : Callback<CoronaList> {
            override fun onResponse(call: Call<CoronaList>, response: Response<CoronaList>) {
                /*if (response.code() == 200) {
                    val regionsResponse = response.body()!!
                    Log.v("Regions", regionsResponse.toString())

                }*/
            }
            override fun onFailure(call: Call<CoronaList>, t: Throwable) {
                Log.v("FailCode",t.toString())

            }
        })*/
    }

}