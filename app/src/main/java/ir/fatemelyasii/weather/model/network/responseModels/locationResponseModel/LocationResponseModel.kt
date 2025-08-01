package ir.fatemelyasii.weather.model.network.responseModels.locationResponseModel

import com.google.gson.annotations.SerializedName

data class LocationResponseModel(
    @SerializedName("Version")
    val version: Int?,
    @SerializedName("Key")
    val key: String?,
    @SerializedName("Type")
    val type: String?,
    @SerializedName("Rank")
    val rank: Int?,
    @SerializedName("LocalizedName")
    val localizedName: String?,
    @SerializedName("EnglishName")
    val englishName: String?,
    @SerializedName("PrimaryPostalCode")
    val primaryPostalCode: String?,
    @SerializedName("Region")
    val region: NameResponseModel?,
    @SerializedName("Country")
    val country: NameResponseModel?,
    @SerializedName("timeZone")
    val timeZoneResponseModel: TimeZoneResponseModel?,
    @SerializedName("GeoPosition")
    val geoPosition: PositionResponseModel?,
    @SerializedName("IsAlias")
    val isAlias: Boolean?
)
