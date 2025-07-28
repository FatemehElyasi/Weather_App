package ir.fatemelyasii.weather.network

import okhttp3.Interceptor
import okhttp3.Response

private const val APIKEY = "VtKswq8uqVTa3GJ0YYRPwUM8GJRUETUU"

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request()

        val newUrl = requestBuilder.url.newBuilder()
            .addQueryParameter("apikey", APIKEY)
            .build()

        val newRequest = requestBuilder.newBuilder()
            .url(newUrl)
            .build()


        return chain.proceed(newRequest)
    }
}