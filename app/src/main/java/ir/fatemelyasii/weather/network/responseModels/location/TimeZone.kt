package ir.fatemelyasii.weather.network.responseModels.location

import com.google.gson.annotations.SerializedName

data class TimeZone(
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