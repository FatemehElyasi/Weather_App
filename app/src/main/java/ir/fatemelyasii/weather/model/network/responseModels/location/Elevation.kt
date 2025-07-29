package ir.fatemelyasii.weather.model.network.responseModels.location

import com.google.gson.annotations.SerializedName

data class Elevation(
    @SerializedName("Metric")
    val metric:Value,
    @SerializedName("Imperial")
    val imperial:Value
)
