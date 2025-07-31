package ir.fatemelyasii.weather.model.network.responseModels.hourlyForecast

import com.google.gson.annotations.SerializedName
import ir.fatemelyasii.weather.model.network.responseModels.location.ValueResponseModel

data class HourlyForecastResponseModel(
    @SerializedName("Date")
    val date: String,
    @SerializedName("EpochDateTime")
    val epochDateTime: Long,
    @SerializedName("WeatherIcon")
    val weatherIcon: Int,
    @SerializedName("IconPhrase")
    val iconPhrase: String,
    @SerializedName("HasPrecipitation")
    val hasPrecipitation: Boolean,
    @SerializedName("IsDaylight")
    val isDaylight: Boolean,
    @SerializedName("TemperatureResponseModel")
    val temperature: ValueResponseModel
)