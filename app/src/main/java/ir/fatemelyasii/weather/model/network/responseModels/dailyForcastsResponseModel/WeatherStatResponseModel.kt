package ir.fatemelyasii.weather.model.network.responseModels.dailyForcastsResponseModel

import com.google.gson.annotations.SerializedName

data class WeatherStatResponseModel(
    @SerializedName("Icon")
    val icon: Int?,
    @SerializedName("IconPhrase")
    val iconPhrase: String?,
    @SerializedName("HasPrecipitation")
    val hasPrecipitation: Boolean?
)