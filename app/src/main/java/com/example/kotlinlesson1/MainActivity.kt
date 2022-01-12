package com.example.kotlinlesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var btn1: Button? = null
    private var btn2: Button? = null
    private var btn3: Button? = null

    private var krasnodarTemp: TextView? = null
    private var tokyoTemp: TextView? = null
    private var moscowTemp: TextView? = null
    private var moscowC: TextView? = null
    private var krasnodarC: TextView? = null
    private var tokyoC: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeBtn()
        setOnClickListeners()
        initializeCycles()

    }

    private fun initializeBtn() {
        btn1 = findViewById(R.id.button)
        btn2 = findViewById(R.id.button1)
        btn3 = findViewById(R.id.button2)
        moscowTemp = findViewById(R.id.temperature_moscow)
        krasnodarTemp = findViewById(R.id.krasnodar_temperature)
        tokyoTemp = findViewById(R.id.tokyo_temperature)
        moscowC = findViewById(R.id.weather_moscow_tv)
        krasnodarC = findViewById(R.id.krasnodar_weather_tv)
        tokyoC = findViewById(R.id.tokyo_weather_tv)
    }

    private fun setOnClickListeners() {

        val moscowCity = CityInfo("Moscow", -10)
        val krasnodarCity = CityInfo("Krasnodar", 12)
        val tokyoCity = CityInfo("Tokyo", 9)


        btn1!!.setOnClickListener {
            moscowC?.text = moscowCity.town
            moscowTemp?.text = moscowCity.temperature.toString()
        }
        btn2!!.setOnClickListener {
            krasnodarC?.text = krasnodarCity.town
            krasnodarTemp?.text = krasnodarCity.temperature.toString()
        }
        btn3!!.setOnClickListener {
            tokyoC?.text = tokyoCity.town
            tokyoTemp?.text = tokyoCity.temperature.toString()
        }
    }

    private fun initializeCycles() {

        val repoData = Repository.getWeatherList()

        for (weather in repoData) {
            Log.d("TAG", weather.town)
        }
    }
}
