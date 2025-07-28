package ir.fatemelyasii.weather.network.responseModels.location

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("Version")
    val version: Int,
    @SerializedName("Key")
    val key: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Rank")
    val rank: Int,
    @SerializedName("LocalizedName")
    val localizedName: String,
    @SerializedName("EnglishName")
    val englishName: String,
    @SerializedName("PrimaryPostalCode")
    val primaryPostalCode: String,
    @SerializedName("Region")
    val region: Name,
    @SerializedName("Country")
    val country: Name,
    @SerializedName("timeZone")
    val timeZone: TimeZone?,
    @SerializedName("GeoPosition")
    val geoPosition: Position,
    @SerializedName("IsAlias")
    val isAlias: Boolean
)
