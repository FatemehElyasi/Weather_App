package ir.fatemelyasii.weather.model.di

import ir.fatemelyasii.weather.model.network.HeaderInterceptor
import ir.fatemelyasii.weather.model.network.apiService.ApiService
import okhttp3.OkHttpClient
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    companion object {
        const val API_BASE_URL = "baseURL"
        const val API_BASE_URL_ICON_QUALIFIER = "BaseUrlIcon"
    }

    @Single
    @Named(API_BASE_URL)
    fun baseUrl(): String {
        return "https://dataservice.accuweather.com/"
    }

    @Single
    @Named(API_BASE_URL_ICON_QUALIFIER)
    fun baseUrlIcon(): String {
        return "https://developer.accuweather.com/sites/default/files/"
    }

    @Single
    fun provideHeaderInterceptor(): HeaderInterceptor = HeaderInterceptor()


    @Single
    fun provideOkHttpClient(headerInterceptor: HeaderInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .build()

    }

    @Single
    fun provideRetrofit(
        @Named(API_BASE_URL) baseUrl: String,
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Single
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}



