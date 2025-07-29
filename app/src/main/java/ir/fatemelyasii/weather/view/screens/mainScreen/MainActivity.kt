package ir.fatemelyasii.weather.view.screens.mainScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import ir.fatemelyasii.weather.ui.theme.WeatherTheme
import ir.fatemelyasii.weather.utils.MyScreen
import ir.fatemelyasii.weather.view.screens.homeScreen.HomeScreen
import ir.fatemelyasii.weather.view.screens.homeScreen.HomeViewModel
import ir.fatemelyasii.weather.view.screens.weatherScreen.WeatherScreen
import ir.fatemelyasii.weather.view.screens.weatherScreen.WeatherViewModel
import org.koin.compose.viewmodel.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherTheme {

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.primary,
                                )
                            )
                        ),
                    color = Color.Transparent
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MyScreen.HomeScreen
    ) {

        composable<MyScreen.HomeScreen> {
            val viewModel: HomeViewModel = koinViewModel()
            HomeScreen(
                viewModel = viewModel,
                navigateToWeather = { locationViewEntity ->
                    navController.navigate(
                        MyScreen.WeatherScreen(
                            locationKey = locationViewEntity.key.orEmpty(),
                            locationName = locationViewEntity.englishName.orEmpty(),
                            countryName = locationViewEntity.countryName.orEmpty(),
                        )
                    )
                }
            )
        }

        composable<MyScreen.WeatherScreen> { backStackEntry ->
            val viewModel: WeatherViewModel = koinViewModel()
            val dataModel = backStackEntry.toRoute<MyScreen.WeatherScreen>()

            WeatherScreen(
                viewModel = viewModel,
                navigateToHomeScreen = { navController.navigate(MyScreen.HomeScreen) },
                locationKey = dataModel.locationKey,
                locationName = dataModel.locationName,
                country = dataModel.countryName,
            )
        }
    }
}
