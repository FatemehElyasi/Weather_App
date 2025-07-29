package ir.fatemelyasii.weather.model.network.responseModels.dailyForcasts

import com.google.gson.annotations.SerializedName
import ir.fatemelyasii.weather.model.network.responseModels.location.Value

data class Temperature(
    @SerializedName("Minimum")
    val min: Value,
    @SerializedName("Maximum")
    val max: Value
)
