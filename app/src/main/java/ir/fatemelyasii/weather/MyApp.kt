package ir.fatemelyasii.weather

import android.app.Application
import ir.fatemelyasii.weather.network.ApiService
import ir.fatemelyasii.weather.network.HeaderInterceptor
import ir.fatemelyasii.weather.repository.WeatherRepo
import ir.fatemelyasii.weather.repository.WeatherRepoImpl
import okhttp3.OkHttpClient
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(module {
                single {
                    val client = OkHttpClient.Builder()
                        .addInterceptor(HeaderInterceptor())
                        .build()
                    Retrofit
                        .Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .baseUrl("http://dataservice.accuweather.com/")
                        .build()
                }
                //after create apiService
                single {
                    val retrofit: Retrofit = get()
                    retrofit.create(ApiService::class.java)
                }
                //after create repository
                single {
                    val api: ApiService = get()
                    WeatherRepoImpl(api)
                } bind WeatherRepo::class
            })
        }
    }
}
