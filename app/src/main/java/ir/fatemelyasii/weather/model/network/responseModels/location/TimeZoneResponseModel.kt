package ir.fatemelyasii.weather.model.network.responseModels.location

import com.google.gson.annotations.SerializedName

data class TimeZoneResponseModel(
    @SerializedName("Code")
    val code:String,
    @SerializedName("name")
    val name:String,
    @SerializedName("GmtOffset")
    val gmtOffset:Double,
    @SerializedName("IsDaylightSaving")
    val isDaylightSaving:Boolean,
    @SerializedName("NextOffsetChange")
    val nextOffsetChange:String?
)