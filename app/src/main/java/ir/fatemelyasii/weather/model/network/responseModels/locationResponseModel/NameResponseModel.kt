package ir.fatemelyasii.weather.model.network.responseModels.locationResponseModel

import com.google.gson.annotations.SerializedName

data class NameResponseModel(
    @SerializedName("ID")
    val id: String?,
    @SerializedName("LocalizedName")
    val localizedName: String?,
    @SerializedName("EnglishName")
    val englishName: String?
)
