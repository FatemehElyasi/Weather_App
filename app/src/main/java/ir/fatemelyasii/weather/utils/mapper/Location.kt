package ir.fatemelyasii.weather.utils.mapper

import ir.fatemelyasii.weather.network.responseModels.location.Location
import ir.fatemelyasii.weather.viewEntity.LocationViewEntity

fun Location.toViewEntity(): LocationViewEntity {
    return LocationViewEntity(
        name = this.localizedName,
        fullName = "${this.localizedName}, ${this.country.localizedName}",
        latitude = this.geoPosition.latitude,
        longitude = this.geoPosition.longitude,
        key = this.key,
        rank = this.rank,
        englishName = this.englishName,
        localizedName = this.localizedName,
        primaryPostalCode = this.primaryPostalCode,
        regionName = this.region.englishName,
        countryName = this.country.englishName,
        timeZoneName = this.timeZone?.name.orEmpty(),
        isAlias = this.isAlias,

        )
}
