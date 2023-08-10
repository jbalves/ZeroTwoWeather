package com.example.zerotwoweather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.zerotwoweather.R

class NextDaysActivity : AppCompatActivity() {
    lateinit var rvTempList1: RecyclerView
    lateinit var cardAdapter1: AdapterCardTemp1
    class AdapterCardTemp1(): ListAdapter<CardTemp1, CardTempViewHolder>(AdapterCardTemp1)
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_days)
    }

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.zerotwoweather.R




data class DayWeek(val day: String, val temp1: String, val temp2: String)

class AdapterDayWeek():ListAdapter<DayWeek, ViewHolderDayWeek>(AdapterDayWeek)  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDayWeek {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cardTempList1, parent, false)

        return ViewHolderDayWeek(view)
    }

    override fun onBindViewHolder(holder: ViewHolderDayWeek, position: Int) {
        val index = getItem(position)
        holder.bind(index)
    }

    companion object: DiffUtil.ItemCallback<DayWeek>() {
        override fun areItemsTheSame(oldItem: DayWeek, newItem: DayWeek): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DayWeek, newItem: DayWeek): Boolean {
            return oldItem.day == newItem.day
        }

    }

}

class ViewHolderDayWeek(view: View): RecyclerView.ViewHolder(view){
    val day = view.findViewById<TextView>(R.id.dia_semana)
    val temp1 = view.findViewById<TextView>(R.id.Tempmin_TempMax)
    val temp2 = view.findViewById<TextView>(R.id.imageView4)

    fun bind(dayWeek: DayWeek){
        day.text = dayWeek.day
        temp1.text = dayWeek.temp1
        temp2.text = dayWeek.temp2
    }

}


    val cardTempList1 = arrayListOf<CardTemp1> (
        CardTemp1("Segunda", "13-----22"),
        CardTemp1("Terça", "16-------20"),
        CardTemp1("Quarta", "18-----24"),
        CardTemp1("Quinta", "15------21"),
        CardTemp1("Sexta", "13------22"),
        CardTemp1("Sabado", "12-----16"),
        CardTemp1("Domingo", "10-----17")
        )


    cardAdapter1 = AdapterCardTemp1()
    rvTempList1 = findViewById<RecyclerView>(R.id.rv_temp_list2)


