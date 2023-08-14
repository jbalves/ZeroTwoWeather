package com.example.zerotwoweather.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.zerotwoweather.R
import com.example.zerotwoweather.data.model.CardTemperature

class AdapterCardTemp() : ListAdapter<CardTemperature, CardTempViewHolder>(AdapterCardTemp) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTempViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_hora, parent, false)

        return CardTempViewHolder(view)

    }

    override fun onBindViewHolder(holder: CardTempViewHolder, position: Int) {
        val indexCardTemp = getItem(position)
        holder.bind(indexCardTemp)
    }


    companion object : DiffUtil.ItemCallback<CardTemperature>() {
        override fun areItemsTheSame(oldItem: CardTemperature, newItem: CardTemperature): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CardTemperature, newItem: CardTemperature): Boolean {
            return oldItem.time == newItem.time && oldItem.temperature_2m == newItem.temperature_2m
        }

    }


}

class CardTempViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvHora = view.findViewById<TextView>(R.id.tv_horas)
    val tvTemp = view.findViewById<TextView>(R.id.tv_temperatura)

    fun bind(cardTemperature: CardTemperature) {
        tvHora.text = cardTemperature.time
        tvTemp.text = cardTemperature.temperature_2m
    }

}