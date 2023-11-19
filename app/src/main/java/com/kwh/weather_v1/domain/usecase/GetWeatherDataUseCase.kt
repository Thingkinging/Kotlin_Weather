package com.kwh.weather_v1.domain.usecase

import android.content.Context
import com.kwh.weather_v1.domain.model.WeatherData

interface GetWeatherDataUseCase {
    suspend fun execute(
        context: Context,
        latitude: Double,
        longitude: Double
    ): WeatherData
}