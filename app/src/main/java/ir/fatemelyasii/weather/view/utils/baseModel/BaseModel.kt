package ir.fatemelyasii.weather.view.utils.baseModel

sealed class BaseModel<out T> {
    data class Success<T>(val data: T) : BaseModel<T>()
    data class Error(val error: String) : BaseModel<Nothing>()
    data object Loading : BaseModel<Nothing>()
}