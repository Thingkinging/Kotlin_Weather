package com.kwh.weather_v1.di.module

import com.kwh.weather_v1.data.remote.RemoteDataSource
import com.kwh.weather_v1.data.remote.WeatherService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val BASE_URL = "https://api.openweathermap.org/data/3.0/"
    }

    @Provides
    @Singleton
    fun providerWeatherService(): WeatherService {
        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val weatherService: WeatherService by lazy {
            retrofit.create(WeatherService::class.java)
        }

        return weatherService
    }

    @Provides
    @Singleton
    fun providerRemoteDataSource(weatherService: WeatherService): RemoteDataSource {
        return RemoteDataSource(weatherService)
    }
}