package ir.fatemelyasii.weather.model.network.apiService

import ir.fatemelyasii.weather.model.network.responseModels.dailyForcasts.DailyForecasts
import ir.fatemelyasii.weather.model.network.responseModels.hourlyForecast.HourlyForecast
import ir.fatemelyasii.weather.model.network.responseModels.location.Location
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("locations/v1/cities/search")
    suspend fun searchLocation(
        @Query("q") query: String,
    ): Response<List<Location>>

    @GET("forecasts/v1/daily/5day/{location_key}")
    suspend fun getDailyForecasts(
        @Path("location_key") locationKey: String,
        @Query("metric") metric: Boolean = true,
    ): Response<DailyForecasts>

    @GET("forecasts/v1/hourly/12hour/{location_key}")
    suspend fun getHourlyForecasts(
        @Path("location_key") locationKey: String,
        @Query("metric") metric: Boolean = true,
    ): Response<List<HourlyForecast>>
}

