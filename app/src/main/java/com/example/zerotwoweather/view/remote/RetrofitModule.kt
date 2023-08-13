package com.example.zerotwoweather.view.remote

import com.example.zerotwoweather.view.WeatherService
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    fun createWeatherService(){
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://climate-api.open-meteo.com/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))

        retrofit
            .build()
            .create(WeatherService::class.java)
    }
}