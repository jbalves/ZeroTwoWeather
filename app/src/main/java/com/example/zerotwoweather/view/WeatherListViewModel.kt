package com.example.zerotwoweather.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zerotwoweather.view.remote.RetrofitModule
import com.example.zerotwoweather.view.remote.WeatherDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.coroutineScope

class WeatherListViewModel(
    private val weatherService: WeatherService
): ViewModel() {

    private val _weatherListLiveData = MutableLiveData<List<WeatherDto>>()
    val newsListLiveData: LiveData<List<WeatherDto>> = _weatherListLiveData

    private fun getWeatherList(){
        viewModelScope.launch(IO) {

        }
    }

    companion object{
        fun create(): WeatherListViewModel{
            val weatherService = RetrofitModule.createWeatherService()
            return WeatherListViewModel(weatherService)
        }
    }
}