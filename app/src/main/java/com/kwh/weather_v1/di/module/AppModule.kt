package com.kwh.weather_v1.di.module

import com.kwh.weather_v1.data.local.LocalDataSource
import com.kwh.weather_v1.data.remote.RemoteDataSource
import com.kwh.weather_v1.data.repository.WeatherDataRepositoryImpl
import com.kwh.weather_v1.domain.repository.WeatherDataRepository
import com.kwh.weather_v1.domain.usecase.GetWeatherDataUseCase
import com.kwh.weather_v1.domain.usecase.GetWeatherDataUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideWeatherDataRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource,
    ) : WeatherDataRepository {
        return WeatherDataRepositoryImpl(
            localDataSource, remoteDataSource
        )
    }

    @Provides
    @Singleton
    fun providerGetWeatherDataUseCase(
        weatherDataRepository: WeatherDataRepository
    ): GetWeatherDataUseCase {
        return GetWeatherDataUseCaseImpl(weatherDataRepository)
    }
}