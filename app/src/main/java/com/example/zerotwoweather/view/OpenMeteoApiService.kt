package com.example.zerotwoweather.view

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMeteoApiService {
    @GET("weather")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly") hourly: String,
        @Query("apikey") apiKey: String
    ): Response<OpenMeteoResponse>
}