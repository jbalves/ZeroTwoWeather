package com.example.zerotwoweather.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zerotwoweather.view.remote.RetrofitModule
import com.example.zerotwoweather.view.remote.WeatherDto
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class WeatherListViewModel(
    private val weatherService: WeatherService
): ViewModel() {

    private val _weatherListLiveData = MutableLiveData<List<WeatherDto>>()
    val newsListLiveData: LiveData<List<WeatherDto>> = _weatherListLiveData

    init {
        getWeatherList()
    }

    private fun getWeatherList() {
        viewModelScope.launch {
            try {
                val response = weatherService.getWeatherData()
                _weatherListLiveData.value = response.latitude
            } catch (ex: Exception){
                ex.printStackTrace()
            }
        }
    }

    companion object{
        fun create(): WeatherListViewModel{
            val weatherService = RetrofitModule.createWeatherService()
            return WeatherListViewModel(weatherService)
        }
    }
}