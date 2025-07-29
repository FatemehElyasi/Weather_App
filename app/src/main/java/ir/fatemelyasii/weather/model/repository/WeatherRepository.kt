package ir.fatemelyasii.weather.model.repository

import ir.fatemelyasii.weather.view.utils.baseModel.BaseModel
import ir.fatemelyasii.weather.model.viewEntity.DailyForecastViewEntity
import ir.fatemelyasii.weather.model.viewEntity.HourlyForecastViewEntity
import ir.fatemelyasii.weather.model.viewEntity.LocationViewEntity

interface WeatherRepository {

    suspend fun searchLocation(query: String): BaseModel<List<LocationViewEntity>>
    suspend fun getDailyForecasts(locationKey: String): BaseModel<List<DailyForecastViewEntity>>
    suspend fun getHourlyForecasts(locationKey: String): BaseModel<List<HourlyForecastViewEntity>>
}