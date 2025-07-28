package ir.fatemelyasii.weather.network.responseModels.dailyForcasts

import com.google.gson.annotations.SerializedName

data class DailyForecast(
    @SerializedName("Date")
    val date: String,
    @SerializedName("EpochDate")
    val epochDate: Long,
    @SerializedName("Temperature")
    val temperature: Temperature,
    @SerializedName("Day")
    val day: WeatherStat,
    @SerializedName("Night")
    val night: WeatherStat
)
