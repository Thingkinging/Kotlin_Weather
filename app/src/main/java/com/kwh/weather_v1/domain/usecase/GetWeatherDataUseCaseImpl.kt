package com.kwh.weather_v1.domain.usecase

import android.content.Context
import com.kwh.weather_v1.domain.model.WeatherData
import com.kwh.weather_v1.domain.repository.WeatherDataRepository
import javax.inject.Inject

class GetWeatherDataUseCaseImpl @Inject constructor(
    private val weatherDataRepository: WeatherDataRepository
) : GetWeatherDataUseCase {
    override suspend fun execute(
        context: Context,
        latitude: Double,
        longitude: Double
    ): WeatherData {
        return weatherDataRepository.getWeatherData(context, latitude, longitude)
    }
}