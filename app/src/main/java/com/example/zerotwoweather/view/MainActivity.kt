package com.example.zerotwoweather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zerotwoweather.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var rvTempList: RecyclerView
    lateinit var cardAdapter: AdapterCardTemp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardTempList = arrayListOf<CardTemp>(
            CardTemp("6 am", "jsapdoifjasdf", "12º"),
            CardTemp("7 am", "dsifjsa", "14º"),
            CardTemp("8 am", "dasipfhasd", "15º"),
            CardTemp("9 am", "doishfsadf", "16º"),
            CardTemp("10 am", "jsapdoifjasdf", "12º"),
            CardTemp("11 am", "dsifjsa", "14º"),
            CardTemp("12 am", "dasipfhasd", "15º")
            )

        cardAdapter = AdapterCardTemp()
        rvTempList = findViewById<RecyclerView>(R.id.rv_temp_list)

        rvTempList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTempList.adapter = cardAdapter

        cardAdapter.submitList(cardTempList)



    }

    class WeatherActivity : AppCompatActivity() {
        // ...

        private fun fetchWeatherData(latitude: Double, longitude: Double) {
            val apiKey = "SUA_CHAVE_DE_API_AQUI"

            CoroutineScope(Dispatchers.IO).launch {
                val response = RetrofitClient.openMeteoApiService.getWeatherData(latitude, longitude, "yes", apiKey)
                if (response.isSuccessful) {
                    val openMeteoResponse = response.body()
                    // Atualize a interface com os dados do openMeteoResponse
                } else {
                    // Trate os erros
                }
            }
        }
    }

}