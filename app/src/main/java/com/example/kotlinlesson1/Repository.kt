package com.example.kotlinlesson1

object Repository {

    private val weatherList: List<Weather> = listOf(
        Weather("Moscow", -13),
        Weather("Krasnodar", 4),
        Weather("Tokyo", 8)
    )

    fun getWeatherList(): List<Weather> {
        return weatherList
    }

}