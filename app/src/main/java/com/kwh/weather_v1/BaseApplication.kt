package com.kwh.weather_v1

import android.app.Application
import com.kwh.weather_v1.di.component.AppComponent
import com.kwh.weather_v1.di.component.DaggerAppComponent
import com.kwh.weather_v1.di.module.DatabaseModule

class BaseApplication : Application() {
    companion object {
        lateinit var instance: BaseApplication
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        initializeAppComponent()
    }

    private fun initializeAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .databaseModule(DatabaseModule(instance))
            .build()
    }
}