package ir.fatemelyasii.weather

import android.app.Application
import okhttp3.OkHttpClient
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApp:Application() {
    override fun onCreate() {
            super.onCreate()
            startKoin {
                modules(module {
                    single {
                        val client = OkHttpClient.Builder()
                            .build()
                        Retrofit
                            .Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(client)
                            .baseUrl("http://dataservice.accuweather.com/")
                            .build()
                    }
                })
            }
        }
    }
