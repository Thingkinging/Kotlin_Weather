package com.kwh.weather_v1.data.repository

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.kwh.weather_v1.data.local.LocalDataSource
import com.kwh.weather_v1.data.remote.RemoteDataSource
import com.kwh.weather_v1.domain.model.WeatherData
import com.kwh.weather_v1.domain.repository.WeatherDataRepository
import com.kwh.weather_v1.util.NetworkUtils
import javax.inject.Inject

class WeatherDataRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : WeatherDataRepository {
    @RequiresApi(Build.VERSION_CODES.M)
    override suspend fun getWeatherData(
        context: Context,
        latitude: Double,
        longitude: Double
    ): WeatherData {
        return if (NetworkUtils.isNetworkConnected(context)){
            val weatherData = remoteDataSource.getWeatherData(latitude, longitude)
            localDataSource.upsertWeatherData(weatherData)
            weatherData
        } else {
            localDataSource.getWeatherData()
        }
    }
}