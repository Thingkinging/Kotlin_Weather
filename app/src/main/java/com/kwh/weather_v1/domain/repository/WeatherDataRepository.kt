package com.kwh.weather_v1.domain.repository

import android.content.Context
import com.kwh.weather_v1.domain.model.WeatherData

interface WeatherDataRepository {
    suspend fun getWeatherData(
        context: Context,
        latitude: Double,
        longitude: Double
    ) : WeatherData
}