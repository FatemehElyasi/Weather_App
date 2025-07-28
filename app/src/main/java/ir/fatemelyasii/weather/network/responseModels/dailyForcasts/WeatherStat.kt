package ir.fatemelyasii.weather.network.responseModels.dailyForcasts

import com.google.gson.annotations.SerializedName

data class WeatherStat(
    @SerializedName("Icon")
    val icon: Int,
    @SerializedName("IconPhrase")
    val iconPhrase: String,
    @SerializedName("HasPrecipitation")
    val hasPrecipitation: Boolean
)