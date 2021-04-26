package com.example.coronavirus.data

data class Change(
    val active_cases: Int?,
    val death_ratio: Double?,
    val deaths: Int?,
    val recovered: Int?,
    val recovery_ratio: Double?,
    val total_cases: Int?
)