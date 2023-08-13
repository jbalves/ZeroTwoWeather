package com.example.zerotwoweather.view.remote

data class WeatherResponse(
    val daily_units: String,
    val daily: List<WeatherDto>
)

data class WeatherDto(
    val temperature_2m_mean_FGOALS_f3_H: String,
    val time: String
)