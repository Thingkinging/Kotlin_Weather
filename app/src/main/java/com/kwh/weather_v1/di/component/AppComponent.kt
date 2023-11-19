package com.kwh.weather_v1.di.component

import com.kwh.weather_v1.di.module.AppModule
import com.kwh.weather_v1.di.module.DatabaseModule
import com.kwh.weather_v1.di.module.NetworkModule
import com.kwh.weather_v1.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class,
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}