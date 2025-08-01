package ir.fatemelyasii.weather.model.network.apiService

import ir.fatemelyasii.weather.model.network.responseModels.dailyForcastsResponseModel.DailyForecastsResponseModel
import ir.fatemelyasii.weather.model.network.responseModels.hourlyForecastResponseModel.HourlyForecastResponseModel
import ir.fatemelyasii.weather.model.network.responseModels.locationResponseModel.LocationResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("locations/v1/cities/search")
    suspend fun searchLocation(
        @Query("q") query: String,
    ): Response<List<LocationResponseModel>>

    @GET("forecasts/v1/daily/5day/{location_key}")
    suspend fun getDailyForecasts(
        @Path("location_key") locationKey: String,
        @Query("metric") metric: Boolean = true,
    ): Response<DailyForecastsResponseModel>

    @GET("forecasts/v1/hourly/12hour/{location_key}")
    suspend fun getHourlyForecasts(
        @Path("location_key") locationKey: String,
        @Query("metric") metric: Boolean = true,
    ): Response<List<HourlyForecastResponseModel>>
}

