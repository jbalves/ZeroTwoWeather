package com.example.zerotwoweather.view

import com.example.zerotwoweather.view.remote.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET

interface WeatherService {
    @GET("weather/v1/climate?latitude=52.52&longitude=13.41&start_date=1950-01-01&end_date=2050-12-31&models=CMCC_CM2_VHR4,FGOALS_f3_H,HiRAM_SIT_HR,MRI_AGCM3_2_S,EC_Earth3P_HR,MPI_ESM1_2_XR,NICAM16_8S&disable_bias_correction=true&daily=temperature_2m_mean,temperature_2m_max,temperature_2m_min")
    suspend fun getWeatherData(): WeatherResponse
}