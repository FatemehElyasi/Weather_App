package ir.fatemelyasii.weather.network.apiService

import ir.fatemelyasii.weather.network.responseModels.dailyForcasts.DailyForecasts
import ir.fatemelyasii.weather.network.responseModels.hourlyForecast.HourlyForecast
import ir.fatemelyasii.weather.network.responseModels.location.Location
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val APIKEY = "VtKswq8uqVTa3GJ0YYRPwUM8GJRUETUU"

interface ApiService {

    @GET("locations/v1/cities/search")
    suspend fun searchLocation(
        @Query("apikey") apikey: String = APIKEY,
        @Query("q") query: String,
    ): Response<List<Location>>

    @GET("forecasts/v1/daily/5day/{location_key}")
    suspend fun getDailyForecasts(
        @Path("location_key") locationKey: String,
        @Query("apikey") apiKey: String = APIKEY,
        @Query("metric") metric: Boolean = true,
    ): Response<DailyForecasts>

    @GET("forecasts/v1/hourly/12hour/{location_key}")
    suspend fun getHourlyForecasts(
        @Path("location_key") locationKey: String,
        @Query("apikey") apiKey: String = APIKEY,
        @Query("metric") metric: Boolean = true,
    ): Response<List<HourlyForecast>>
}

