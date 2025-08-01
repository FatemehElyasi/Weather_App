package ir.fatemelyasii.weather.model.network.responseModels.locationResponseModel

import com.google.gson.annotations.SerializedName

data class ValueResponseModel(
    @SerializedName("Value")
    val value: Double?,
    @SerializedName("Unit")
    val unit: String?,
    @SerializedName("UnitType")
    val unitType: Int?
)
