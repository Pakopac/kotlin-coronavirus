package com.example.coronavirus.data

data class France(
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
    val total_cases: Int?
)