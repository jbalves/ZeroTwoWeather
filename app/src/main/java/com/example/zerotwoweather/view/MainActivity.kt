package com.example.zerotwoweather.view

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zerotwoweather.R
import com.example.zerotwoweather.data.model.CardTemperature
import com.example.zerotwoweather.view.adapters.AdapterCardTemp
import com.example.zerotwoweather.viewmodel.WeatherListViewModel
import java.time.LocalDate
import java.util.Locale

class MainActivity : AppCompatActivity(), LocationListener {

    lateinit var cityTextView: TextView
    lateinit var monthDayTextView: TextView
    lateinit var rvTempList: RecyclerView
    lateinit var cardAdapter: AdapterCardTemp
    private val viewModel by lazy { WeatherListViewModel.create() }
    private lateinit var locationManager: LocationManager
    private val locationPermissionCode = 2
    private lateinit var geocoder: Geocoder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardAdapter = AdapterCardTemp()
        rvTempList = findViewById(R.id.rv_temp_list)
        cityTextView = findViewById(R.id.cityTextView)
        monthDayTextView = findViewById(R.id.monthDayTextView)

        rvTempList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTempList.adapter = cardAdapter

        geocoder = Geocoder(this, Locale.getDefault())
        getLastLocation()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            monthDayTextView.text = LocalDate.now().dayOfMonth.toString() + " " + LocalDate.now().month.toString()+ ", " + LocalDate.now().dayOfWeek.toString()
        }

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

    private fun getLastLocation() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                locationPermissionCode
            )
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 5f,this)
    }
    override fun onLocationChanged(location: Location) {
        val address = geocoder.getFromLocation(location.latitude,location.longitude,1)
        cityTextView.text = address?.get(0)?.locality
        cityTextView.text = address?.get(0)?.subAdminArea
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == locationPermissionCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }
}