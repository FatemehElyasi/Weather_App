package ir.fatemelyasii.weather.repository

import ir.fatemelyasii.weather.network.responseModels.hourlyForecast.HourlyForecast
import ir.fatemelyasii.weather.network.responseModels.dailyForcasts.DailyForecasts
import ir.fatemelyasii.weather.network.responseModels.location.Location
import ir.fatemelyasii.weather.utils.BaseModel

interface WeatherRepository {

    suspend fun searchLocation(query: String): BaseModel<List<Location>>
    suspend fun getDailyForecasts(locationKey: String): BaseModel<DailyForecasts>
    suspend fun getHourlyForecasts(locationKey: String): BaseModel<List<HourlyForecast>>
}