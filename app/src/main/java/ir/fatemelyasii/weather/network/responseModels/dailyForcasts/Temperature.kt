package ir.fatemelyasii.weather.network.responseModels.dailyForcasts

import com.google.gson.annotations.SerializedName
import ir.fatemelyasii.weather.network.responseModels.location.Value

data class Temperature(
    @SerializedName("Minimum")
    val min: Value,
    @SerializedName("Maximum")
    val max: Value
)
