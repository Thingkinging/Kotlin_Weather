package com.kwh.weather_v1.di.module

import android.app.Application
import androidx.room.Room
import com.kwh.weather_v1.data.local.AppDatabase
import com.kwh.weather_v1.data.local.LocalDataSource
import com.kwh.weather_v1.data.local.WeatherDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule (
    private val application: Application
){
    @Provides
    @Singleton
    fun providerAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "mosam_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providerWeatherDao(appDatabase: AppDatabase): WeatherDao {
        return appDatabase.weatherDao()
    }

    @Provides
    @Singleton
    fun providerLocalDataSource(weatherDao: WeatherDao): LocalDataSource {
        return LocalDataSource(weatherDao)
    }
}