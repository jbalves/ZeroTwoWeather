package com.example.zerotwoweather.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.viewModelScope
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zerotwoweather.R
import com.example.zerotwoweather.view.remote.RetrofitModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var rvTempList: RecyclerView
    lateinit var cardAdapter: AdapterCardTemp

    private val retrofitModule = RetrofitModule

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

        viewModel.newsListLiveData.observe(this) { weatherList ->
            cardTempList.map { weatherDto ->
                CardTemp(
                    hora = weatherDto.hora,
                    imagemClima = weatherDto.imagemClima,
                    temp = weatherDto.temp
                )
            }
        }

        val btnOpenDay = findViewById<Button>(R.id.btn_open_dayWeek)
        btnOpenDay.setOnClickListener {
            openDay()
        }

    }
    fun openDay(){
        val intent = Intent(this, ActivityDayWeek::class.java)
        startActivity(intent)
    }
}