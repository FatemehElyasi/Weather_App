package ir.fatemelyasii.weather.viewEntity

data class LocationViewEntity(
    val name: String,
    val fullName: String,
    val rank: Int,
    val key: String,
    val localizedName: String,
    val englishName: String,
    val primaryPostalCode: String,
    val regionName: String,
    val countryName: String,
    val timeZoneName: String,
    val latitude: Double,
    val longitude: Double,
    val isAlias: Boolean,

)
