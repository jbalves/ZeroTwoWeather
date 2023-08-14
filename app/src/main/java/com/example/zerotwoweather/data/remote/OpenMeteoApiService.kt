package com.example.zerotwoweather.data.remote

import retrofit2.http.GET

interface WeatherService {
    @GET("v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m")
    suspend fun getWeatherData(): WeatherResponse
}