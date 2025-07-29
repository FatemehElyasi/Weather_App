package ir.fatemelyasii.weather.model.network.responseModels.location

import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("ID")
    val id: String,
    @SerializedName("LocalizedName")
    val localizedName: String,
    @SerializedName("EnglishName")
    val englishName: String
)
