package com.example.zerotwoweather.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("v1/forecast")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double = Constants.LATITUDE,
        @Query("longitude") longitude: Double = Constants.LONGITUDE,
        @Query("hourly") hourly: String = Constants.HOURLY_PARAM
    ): WeatherResponse
}