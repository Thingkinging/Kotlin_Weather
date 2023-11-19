package com.kwh.weather_v1.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kwh.weather_v1.domain.usecase.GetWeatherDataUseCase
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class WeatherViewModelFactory @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return WeatherViewModel(getWeatherDataUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}