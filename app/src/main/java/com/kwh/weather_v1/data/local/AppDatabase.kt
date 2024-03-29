package com.kwh.weather_v1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WeatherEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun weatherDao(): WeatherDao
}