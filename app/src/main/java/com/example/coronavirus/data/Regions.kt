package com.example.coronavirus.data

import com.google.gson.annotations.SerializedName

data class Regions(@SerializedName("id")
   val active_cases: Int?,
   val critical: Int?,
   val death_ratio: Double?,
   val deaths: Int?,
   val iso3166a2: String?,
   val iso3166a3: String?,
   val iso3166numeric: String?,
   val name: String?,
   val recovered: Int?,
   val recovery_ratio: Double?,
   val tested: Int?,
   val total_cases: Int?){
    override fun toString(): String {
        return "$iso3166a2 $iso3166a3 $iso3166numeric $name"
    }
}