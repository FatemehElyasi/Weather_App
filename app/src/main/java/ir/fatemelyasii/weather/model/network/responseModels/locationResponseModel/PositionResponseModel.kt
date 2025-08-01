package ir.fatemelyasii.weather.model.network.responseModels.locationResponseModel

import com.google.gson.annotations.SerializedName

data class PositionResponseModel(
    @SerializedName("Latitude")
    val latitude: Double?,
    @SerializedName("Longitude")
    val longitude: Double?,
    @SerializedName("Elevation")
    val elevation: ElevationResponseModel?
)

