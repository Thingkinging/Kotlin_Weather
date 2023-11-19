package com.kwh.weather_v1.data.remote

import com.kwh.weather_v1.data.mapper.WeatherResponseMapper
import com.kwh.weather_v1.domain.model.EmptyWeatherData
import com.kwh.weather_v1.domain.model.WeatherData
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val weatherService: WeatherService
) {
    suspend fun getWeatherData(
        latitude: Double,
        longitude: Double
    ): WeatherData {
        val response = weatherService.getWeatherData(latitude, longitude)
        if (response.isSuccessful) {
            response.body()?.let {
                return WeatherResponseMapper.mapWeatherResponseToWeatherData(it)
            }
        }
        return EmptyWeatherData.instance
    }
}