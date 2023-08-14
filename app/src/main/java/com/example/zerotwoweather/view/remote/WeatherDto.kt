package com.example.zerotwoweather.view.remote

import java.time.LocalDateTime

data class WeatherResponse(
    val hourly: WeatherDto
)

data class WeatherDto(
    val time: List<String>,
    val temperature_2m: List<String>
)