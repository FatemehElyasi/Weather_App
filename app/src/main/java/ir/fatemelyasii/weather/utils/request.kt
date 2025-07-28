package ir.fatemelyasii.weather.utils

import android.util.Log
import ir.fatemelyasii.weather.utils.baseModel.BaseModel
import retrofit2.Response

suspend fun <T> request(request: suspend () -> Response<T>): BaseModel<T> {
    return try {
        val response = request()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                BaseModel.Success(body)
            } else {
                BaseModel.Error("Empty response body")
            }
        } else {
            val errorBody = response.errorBody()?.string()
            val code = response.code()
            Log.e("API_ERROR", "Error code: $code, message: $errorBody")

            BaseModel.Error("Error $code: $errorBody")
        }
    } catch (e: Exception) {
        Log.e("API_EXCEPTION", "Exception: ${e.message}")
        BaseModel.Error(e.message ?: "Unknown error")
    }
}

