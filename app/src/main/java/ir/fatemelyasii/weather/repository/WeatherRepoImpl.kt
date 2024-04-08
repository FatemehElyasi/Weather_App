package ir.fatemelyasii.weather.repository

import ir.fatemelyasii.weather.model.DailyForecasts
import ir.fatemelyasii.weather.model.HourlyForecast
import ir.fatemelyasii.weather.model.Location
import ir.fatemelyasii.weather.network.ApiService
import ir.fatemelyasii.weather.utils.BaseModel
import retrofit2.Response

 class WeatherRepoImpl(private val apiService: ApiService) : WeatherRepo {
    override suspend fun searchLocation(query: String): BaseModel<List<Location>> {
        return request {
            apiService.searchLocation(query = query)
        }
    }

    override suspend fun getDailyForecasts(locationKey: String): BaseModel<DailyForecasts> {
        return request {
            apiService.getDailyForecasts(locationKey = locationKey)
        }
    }

    override suspend fun getHourlyForecasts(locationKey: String): BaseModel<List<HourlyForecast>> {
        return request {
            apiService.getHourlyForecasts(locationKey = locationKey)
        }
    }
}

//-------------------------------------------------------------------------------
suspend fun <T> request(request: suspend () -> Response<T>): BaseModel<T> {
    try {
        request().also {
            return if (it.isSuccessful) {
                BaseModel.Success(it.body()!!)
            } else {
                BaseModel.Error(it.errorBody()?.string().toString())
            }
        }
    } catch (e: Exception) {
        return BaseModel.Error(e.message.toString())
    }
}