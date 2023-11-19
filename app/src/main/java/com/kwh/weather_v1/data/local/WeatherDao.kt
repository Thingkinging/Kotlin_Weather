package com.kwh.weather_v1.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface WeatherDao {
    @Upsert
    suspend fun upsertWeatherData(weatherEntity: WeatherEntity)

    @Query("select * from weather_data")
    suspend fun getWeatherData(): WeatherEntity?
}