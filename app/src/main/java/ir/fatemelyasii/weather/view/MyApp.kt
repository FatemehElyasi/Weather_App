package ir.fatemelyasii.weather.view

import android.app.Application
import ir.fatemelyasii.weather.model.di.ApplicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.defaultModule
import org.koin.ksp.generated.module

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
                ApplicationModule().module,
                defaultModule
            )

        }
    }
}