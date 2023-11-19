package com.kwh.weather_v1.data.local

import com.kwh.weather_v1.data.mapper.WeatherEntityMapper
import com.kwh.weather_v1.domain.model.EmptyWeatherData
import com.kwh.weather_v1.domain.model.WeatherData
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val weatherDao: WeatherDao
){
    suspend fun upsertWeatherData(weatherData: WeatherData) {
        weatherDao.upsertWeatherData(
            WeatherEntityMapper.mapWeatherDataToWeatherEntity(weatherData)
        )
    }

    suspend fun getWeatherData(): WeatherData {
        return weatherDao.getWeatherData()?.let {
            WeatherEntityMapper.mapWeatherEntityToWeatherData(it)
        } ?: EmptyWeatherData.instance
    }
}