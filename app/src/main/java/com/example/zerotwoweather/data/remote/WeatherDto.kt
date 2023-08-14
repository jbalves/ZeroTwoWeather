package com.example.zerotwoweather.data.remote

data class WeatherResponse(
    val hourly: WeatherDto
)

data class WeatherDto(
    val time: List<String>,
    val temperature_2m: List<String>
)