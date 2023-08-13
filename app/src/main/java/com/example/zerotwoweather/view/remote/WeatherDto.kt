package com.example.zerotwoweather.view.remote

data class WeatherResponse(
//    val daily_units: List<WeatherDto>,
//    val daily: List<WeatherDto>,
    val latitude: List<WeatherDto>,
    val longitude: String,
)

data class WeatherDto(
    val temperature_2m_mean_FGOALS_f3_H: String,
    val time: String
)