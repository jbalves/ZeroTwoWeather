package com.example.zerotwoweather.view

data class OpenMeteoResponse(
    val hourly: List<HourlyWeather>
)

data class HourlyWeather(
    val time: Long,
    val temperature_2m: Double,
    val humidity_2m: Double,
    val weathercode: String
)