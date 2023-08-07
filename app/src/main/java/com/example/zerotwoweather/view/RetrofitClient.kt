package com.example.zerotwoweather.view

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://climate-api.open-meteo.com/v1/climate?latitude=52.52&longitude=13.41&start_date=1950-01-01&end_date=2050-12-31&models=CMCC_CM2_VHR4,FGOALS_f3_H,HiRAM_SIT_HR,MRI_AGCM3_2_S,EC_Earth3P_HR,MPI_ESM1_2_XR,NICAM16_8S&daily=temperature_2m_max"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val openMeteoApiService: OpenMeteoApiService = retrofit.create(OpenMeteoApiService::class.java)
}