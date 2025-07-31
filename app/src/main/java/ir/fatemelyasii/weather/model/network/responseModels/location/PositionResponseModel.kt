package ir.fatemelyasii.weather.model.network.responseModels.location

import com.google.gson.annotations.SerializedName

data class PositionResponseModel(
    @SerializedName("Latitude")
    val latitude: Double,
    @SerializedName("Longitude")
    val longitude: Double,
    @SerializedName("ElevationResponseModel")
    val elevation: ElevationResponseModel
)

