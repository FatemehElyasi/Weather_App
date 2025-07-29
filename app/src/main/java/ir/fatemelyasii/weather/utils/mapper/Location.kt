package ir.fatemelyasii.weather.utils.mapper

import ir.fatemelyasii.weather.network.responseModels.location.Location
import ir.fatemelyasii.weather.viewEntity.LocationViewEntity

fun Location.toViewEntity(): LocationViewEntity {
    return LocationViewEntity(
        key = this.key,
        englishName = this.englishName,
        countryName = this.country.englishName,
    )
}
