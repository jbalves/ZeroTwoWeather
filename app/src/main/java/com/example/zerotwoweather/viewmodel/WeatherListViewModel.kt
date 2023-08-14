package com.example.zerotwoweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zerotwoweather.data.model.CardTemperature
import com.example.zerotwoweather.data.remote.WeatherService
import com.example.zerotwoweather.data.remote.RetrofitModule
import com.example.zerotwoweather.data.remote.WeatherDto
import kotlinx.coroutines.launch

class WeatherListViewModel(
    private val weatherService: WeatherService
) : ViewModel() {

    private val _weatherListLiveData = MutableLiveData<List<CardTemperature>>()
    val weatherListLiveData: LiveData<List<CardTemperature>> = _weatherListLiveData

    init {
        getWeatherList()
    }

    private fun getWeatherList() {
        viewModelScope.launch {
            try {
                val response = weatherService.getWeatherData()
                val cardTemperatureList = mapToCardTemperature(response.hourly)
                _weatherListLiveData.value = cardTemperatureList
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }

    // Function to transform WeatherDto into List<CardTemperature>
    private fun mapToCardTemperature(weatherDto: WeatherDto): List<CardTemperature> {
        val cardList = mutableListOf<CardTemperature>()

        // Assuming that time and temperature_2m lists are of the same size
        for (i in weatherDto.time.indices) {
            val time = weatherDto.time[i]
            val temperature = weatherDto.temperature_2m[i]
            cardList.add(CardTemperature(time, temperature))
        }

        return cardList
    }

    companion object {
        fun create(): WeatherListViewModel {
            val weatherService = RetrofitModule.createWeatherService()
            return WeatherListViewModel(weatherService)
        }
    }
}