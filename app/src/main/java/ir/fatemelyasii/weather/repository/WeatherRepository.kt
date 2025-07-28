package ir.fatemelyasii.weather.repository

import ir.fatemelyasii.weather.utils.baseModel.BaseModel
import ir.fatemelyasii.weather.viewEntity.DailyForecastViewEntity
import ir.fatemelyasii.weather.viewEntity.HourlyForecastViewEntity
import ir.fatemelyasii.weather.viewEntity.LocationViewEntity

interface WeatherRepository {

    suspend fun searchLocation(query: String): BaseModel<List<LocationViewEntity>>
    suspend fun getDailyForecasts(locationKey: String): BaseModel<List<DailyForecastViewEntity>>
    suspend fun getHourlyForecasts(locationKey: String): BaseModel<List<HourlyForecastViewEntity>>
}