package com.example.coronavirus.data

import com.google.gson.annotations.SerializedName

data class CoronaList(@SerializedName("Regions") var Regions: List<CoronaList>)