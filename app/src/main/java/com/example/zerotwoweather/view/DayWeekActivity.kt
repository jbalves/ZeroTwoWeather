package com.example.zerotwoweather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.zerotwoweather.R
import com.example.zerotwoweather.data.model.DayWeek
import com.example.zerotwoweather.view.adapters.AdapterDayWeek

class DayWeekActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_week)


        val listDayWeek = arrayListOf<DayWeek>(
            DayWeek("Segunda", "15º", "26º"),
            DayWeek("Terça", "12º", "17º"),
            DayWeek("Quarta", "20º", "31º"),
            DayWeek("Quinta", "8º", "16º"),
            DayWeek("Sexta", "20º", "33º"),
            DayWeek("Sábado", "23º", "29º"),
            DayWeek("Domingo", "2º", "10º")
            )


        val adapterDayWeek = AdapterDayWeek()

        val rvDayWeek = findViewById<RecyclerView>(R.id.rv_day_week)
        rvDayWeek.adapter = adapterDayWeek
        adapterDayWeek.submitList(listDayWeek)
    }
}