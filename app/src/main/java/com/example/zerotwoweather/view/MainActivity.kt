package com.example.zerotwoweather.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zerotwoweather.R
import com.example.zerotwoweather.data.model.CardTemperature
import com.example.zerotwoweather.view.adapters.AdapterCardTemp
import com.example.zerotwoweather.viewmodel.WeatherListViewModel

class MainActivity : AppCompatActivity() {

    lateinit var rvTempList: RecyclerView
    lateinit var cardAdapter: AdapterCardTemp

    private val viewModel by lazy { WeatherListViewModel.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardAdapter = AdapterCardTemp()
        rvTempList = findViewById<RecyclerView>(R.id.rv_temp_list)

        rvTempList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTempList.adapter = cardAdapter


        viewModel.weatherListLiveData.observe(this) { cardTempList ->
            val cardList = cardTempList.map { weatherDto ->

                CardTemperature(
                    time = weatherDto.time.toString(),
                    temperature_2m = weatherDto.temperature_2m.toString()
                )
            }
            cardAdapter.submitList(cardList)
        }

        val btnOpenDay = findViewById<Button>(R.id.btn_open_dayWeek)
        btnOpenDay.setOnClickListener {
            openDay()
        }

    }
    fun openDay(){
        val intent = Intent(this, DayWeekActivity::class.java)
        startActivity(intent)
    }
}