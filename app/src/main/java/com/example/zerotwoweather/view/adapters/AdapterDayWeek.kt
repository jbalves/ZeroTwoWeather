package com.example.zerotwoweather.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.zerotwoweather.R
import com.example.zerotwoweather.data.model.DayWeek

class AdapterDayWeek():ListAdapter<DayWeek, ViewHolderDayWeek>(AdapterDayWeek)  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDayWeek {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_days_detail, parent, false)

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
    val day = view.findViewById<TextView>(R.id.tv_name_day_week)
    val temp1 = view.findViewById<TextView>(R.id.temp1)
    val temp2 = view.findViewById<TextView>(R.id.temp2)

    fun bind(dayWeek: DayWeek){
        day.text = dayWeek.day
        temp1.text = dayWeek.temp1
        temp2.text = dayWeek.temp2
    }

}