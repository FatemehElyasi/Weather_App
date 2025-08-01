package ir.fatemelyasii.weather.model.repository

import ir.fatemelyasii.weather.model.network.apiService.ApiService
import ir.fatemelyasii.weather.model.viewEntity.DailyForecastViewEntity
import ir.fatemelyasii.weather.model.viewEntity.HourlyForecastViewEntity
import ir.fatemelyasii.weather.model.viewEntity.LocationViewEntity
import ir.fatemelyasii.weather.view.utils.baseModel.BaseModel
import ir.fatemelyasii.weather.view.utils.mapper.toViewEntity
import ir.fatemelyasii.weather.view.utils.request
import map
import org.koin.core.annotation.Single

@Single
class WeatherRepoImpl(
    private val apiService: ApiService
) : WeatherRepository {

    override suspend fun searchLocation(query: String): BaseModel<List<LocationViewEntity>> {
        return request {
            apiService.searchLocation(query = query)
        }.map { list -> list.map { it.toViewEntity() } }
    }
    override suspend fun getDailyForecasts(locationKey: String): BaseModel<List<DailyForecastViewEntity>> {
        return request {
            apiService.getDailyForecasts(locationKey)
        }.map { response ->
            val list = response.dailyForecastResponseModels ?: emptyList()
            list.map { it.toViewEntity() }
        }
    }

    override suspend fun getHourlyForecasts(locationKey: String): BaseModel<List<HourlyForecastViewEntity>> {
        return request {
            apiService.getHourlyForecasts(locationKey = locationKey)
        }.map { list -> list.map { it.toViewEntity() } }
    }
}

