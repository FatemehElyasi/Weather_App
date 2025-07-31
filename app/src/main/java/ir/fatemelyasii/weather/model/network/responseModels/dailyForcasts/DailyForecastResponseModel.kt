package ir.fatemelyasii.weather.model.network.responseModels.dailyForcasts

import com.google.gson.annotations.SerializedName

data class DailyForecastResponseModel(
    @SerializedName("Date")
    val date: String,
    @SerializedName("EpochDate")
    val epochDate: Long,
    @SerializedName("TemperatureResponseModel")
    val temperature: TemperatureResponseModel,
    @SerializedName("Day")
    val day: WeatherStatResponseModel,
    @SerializedName("Night")
    val night: WeatherStatResponseModel
)
