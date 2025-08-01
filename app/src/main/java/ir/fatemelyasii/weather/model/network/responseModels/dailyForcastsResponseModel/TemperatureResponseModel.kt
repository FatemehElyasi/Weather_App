package ir.fatemelyasii.weather.model.network.responseModels.dailyForcastsResponseModel

import com.google.gson.annotations.SerializedName
import ir.fatemelyasii.weather.model.network.responseModels.locationResponseModel.ValueResponseModel

data class TemperatureResponseModel(
    @SerializedName("Minimum")
    val min: ValueResponseModel?,
    @SerializedName("Maximum")
    val max: ValueResponseModel?
)
