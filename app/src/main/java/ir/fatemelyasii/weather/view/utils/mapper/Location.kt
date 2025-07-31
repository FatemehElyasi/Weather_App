package ir.fatemelyasii.weather.view.utils.mapper

import ir.fatemelyasii.weather.model.network.responseModels.location.LocationResponseModel
import ir.fatemelyasii.weather.model.viewEntity.LocationViewEntity

fun LocationResponseModel.toViewEntity(): LocationViewEntity {
    return LocationViewEntity(
        key = this.key,
        englishName = this.englishName,
        countryName = this.country.englishName,
    )
}
