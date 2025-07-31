package ir.fatemelyasii.weather.model.network.responseModels.dailyForcasts

import com.google.gson.annotations.SerializedName
import ir.fatemelyasii.weather.model.network.responseModels.location.ValueResponseModel

data class TemperatureResponseModel(
    @SerializedName("Minimum")
    val min: ValueResponseModel,
    @SerializedName("Maximum")
    val max: ValueResponseModel
)
