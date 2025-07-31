package ir.fatemelyasii.weather.view.utils.mapper

import ir.fatemelyasii.weather.model.network.responseModels.location.Location
import ir.fatemelyasii.weather.model.viewEntity.LocationViewEntity

fun Location.toViewEntity(): LocationViewEntity {
    return LocationViewEntity(
        key = this.key,
        englishName = this.englishName,
        countryName = this.country?.englishName,
    )
}
