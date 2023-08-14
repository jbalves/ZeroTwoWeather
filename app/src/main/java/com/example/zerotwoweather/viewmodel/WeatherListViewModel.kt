package com.example.zerotwoweather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zerotwoweather.data.remote.WeatherService
import com.example.zerotwoweather.data.remote.RetrofitModule
import com.example.zerotwoweather.data.remote.WeatherDto
import kotlinx.coroutines.launch

class WeatherListViewModel(
    private val weatherService: WeatherService
): ViewModel() {

    private val _weatherListLiveData = MutableLiveData<List<WeatherDto>>()
    val weatherListLiveData: LiveData<List<WeatherDto>> = _weatherListLiveData

    init {
        getWeatherList()
    }

    private fun getWeatherList() {
        viewModelScope.launch {
            try {
                val response = weatherService.getWeatherData()
                _weatherListLiveData.value = listOf(response.hourly)
            } catch (ex: Exception){
                ex.printStackTrace()
            }
        }
    }

    companion object{
        fun create(): WeatherListViewModel {
            val weatherService = RetrofitModule.createWeatherService()
            return WeatherListViewModel(weatherService)
        }
    }
}