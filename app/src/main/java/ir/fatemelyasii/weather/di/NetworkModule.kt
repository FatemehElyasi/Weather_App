package ir.fatemelyasii.weather.di

import ir.fatemelyasii.weather.network.apiService.HeaderInterceptor
import ir.fatemelyasii.weather.network.apiService.ApiService
import okhttp3.OkHttpClient
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Single
    fun baseUrl(): String {
        return "https://dataservice.accuweather.com/"
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
        baseUrl: String,
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



