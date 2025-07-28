import ir.fatemelyasii.weather.utils.baseModel.BaseModel

inline fun <T, R> BaseModel<T>.map(transform: (T) -> R): BaseModel<R> {
    return when (this) {
        is BaseModel.Success -> BaseModel.Success(transform(this.data))
        is BaseModel.Error -> BaseModel.Error(this.error)
        is BaseModel.Loading -> BaseModel.Loading
    }
}
