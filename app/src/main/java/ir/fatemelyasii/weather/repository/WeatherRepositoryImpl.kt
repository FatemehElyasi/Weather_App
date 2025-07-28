package ir.fatemelyasii.weather.repository

import ir.fatemelyasii.weather.network.apiService.ApiService
import ir.fatemelyasii.weather.utils.baseModel.BaseModel
import ir.fatemelyasii.weather.utils.mapper.toViewEntity
import ir.fatemelyasii.weather.utils.request
import ir.fatemelyasii.weather.viewEntity.DailyForecastViewEntity
import ir.fatemelyasii.weather.viewEntity.HourlyForecastViewEntity
import ir.fatemelyasii.weather.viewEntity.LocationViewEntity
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
            response.dailyForecasts.map { it.toViewEntity() }
        }
    }

    override suspend fun getHourlyForecasts(locationKey: String): BaseModel<List<HourlyForecastViewEntity>> {
        return request {
            apiService.getHourlyForecasts(locationKey = locationKey)
        }.map { list -> list.map { it.toViewEntity() } }
    }
}

