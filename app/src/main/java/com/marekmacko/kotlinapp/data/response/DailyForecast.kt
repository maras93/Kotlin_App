package com.marekmacko.kotlinapp.data.response

import java.io.Serializable
import java.text.DateFormat
import java.util.*


data class DailyForecast(private val dt: Long, val temp: Temperature,
                         val pressure: Float, val humidity: Int,
                         val weather: List<Weather>, val speed: Float,
                         val deg: Int, val clouds: Int,
                         val rain: Float) : Serializable {

    companion object {
        private val dateFormatter by lazy {
            DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        }
    }

    val date: String
        get() = dateFormatter.format(dt * 1000)
}