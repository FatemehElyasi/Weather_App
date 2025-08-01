package ir.fatemelyasii.weather.model.network.responseModels.locationResponseModel

import com.google.gson.annotations.SerializedName

data class ElevationResponseModel(
    @SerializedName("Metric")
    val metric:ValueResponseModel?,
    @SerializedName("Imperial")
    val imperial:ValueResponseModel?
)
