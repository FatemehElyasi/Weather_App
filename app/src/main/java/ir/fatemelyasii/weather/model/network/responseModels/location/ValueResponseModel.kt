package ir.fatemelyasii.weather.model.network.responseModels.location

import com.google.gson.annotations.SerializedName

data class ValueResponseModel(
    @SerializedName("ValueResponseModel")
    val valueResponseModel: Double,
    @SerializedName("Unit")
    val unit: String,
    @SerializedName("UnitType")
    val unitType: Int
)
