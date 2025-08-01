package ir.fatemelyasii.weather.model.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(
    [
        NetworkModule::class,
    ]
)
@ComponentScan("ir.fatemelyasi.weather")
class ApplicationModule
