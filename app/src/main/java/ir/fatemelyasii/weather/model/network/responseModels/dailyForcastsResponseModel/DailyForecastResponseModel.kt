package ir.fatemelyasii.weather.model.network.responseModels.dailyForcastsResponseModel

import com.google.gson.annotations.SerializedName

data class DailyForecastResponseModel(
    @SerializedName("Date")
    val date: String?,
    @SerializedName("EpochDate")
    val epochDate: Long?,
    @SerializedName("Temperature")
    val temperature: TemperatureResponseModel?,
    @SerializedName("Day")
    val day: WeatherStatResponseModel?,
    @SerializedName("Night")
    val night: WeatherStatResponseModel?
)
