package com.example.coronavirus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = ApiClient.retrofitInstance?.create(ApiService::class.java)
        val call = service.getCountries()



        /*val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)*/

        //api.getCountries().create(ApiInterface::class.java)

       /* GlobalScope.launch(Dispatchers.IO) {
            val countries = api.getCountries()
            for()
            Log.v("countries", countries.toString())

        }*/


    }

    private lateinit var favoritesViewModel: FavoritesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        favoritesViewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)

        val binding: FragmentFavoritesBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_favorites, container, false
        )

        return binding.root
    }
}