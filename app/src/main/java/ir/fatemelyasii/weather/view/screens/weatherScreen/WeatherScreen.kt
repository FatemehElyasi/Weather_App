package ir.fatemelyasii.weather.view.screens.weatherScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.sharp.ArrowDownward
import androidx.compose.material.icons.sharp.ArrowUpward
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ir.fatemelyasii.weather.R
import ir.fatemelyasii.weather.model.viewEntity.DailyForecastViewEntity
import ir.fatemelyasii.weather.model.viewEntity.HourlyForecastViewEntity
import ir.fatemelyasii.weather.view.ui.theme.russoFont
import ir.fatemelyasii.weather.view.utils.baseModel.BaseModel
import org.koin.compose.viewmodel.koinViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun WeatherScreen(
    navigateToHomeScreen: () -> Unit,
    locationKey: String,
    locationName: String,
    country: String,
    viewModel: WeatherViewModel = koinViewModel()
) {
    val dailyForecasts by viewModel.dailyForecast.collectAsState()
    val hourlyForecasts by viewModel.hourlyForecast.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getDailyForecast(locationKey)
        viewModel.getHourlyForecast(locationKey)
    }

    Column(
        modifier = Modifier
        .padding(horizontal = 16.dp)
    ) {
        WeatherHeader(locationName, country, onBackClick = navigateToHomeScreen)


        AnimatedVisibility(visible = hourlyForecasts is BaseModel.Success) {
            val data = (hourlyForecasts as BaseModel.Success<List<HourlyForecastViewEntity>>).data
            data.firstOrNull()?.temperature?.let {
                TemperatureDisplay(
                    temp = it.toInt()
                )
            }
        }

        AnimatedVisibility(visible = hourlyForecasts is BaseModel.Loading) {
            LoadingState()
        }

        Spacer(modifier = Modifier.height(16.dp))

        ForecastSectionTitle(stringResource(R.string.hourly_forecasts))

        AnimatedVisibility(visible = hourlyForecasts is BaseModel.Success) {
            val data = (hourlyForecasts as BaseModel.Success<List<HourlyForecastViewEntity>>).data
            HourlyForecastList(data)
        }

        AnimatedVisibility(visible = hourlyForecasts is BaseModel.Loading) {
            LoadingState()
        }

        Spacer(modifier = Modifier.height(16.dp))

        ForecastSectionTitle(stringResource(R.string.daily_forecasts))

        AnimatedVisibility(visible = dailyForecasts is BaseModel.Success) {
            val data = (dailyForecasts as BaseModel.Success<List<DailyForecastViewEntity>>).data
            if (data.isEmpty()) {
                Text("No daily forecasts available", color = Color.White)
            } else {
                DailyForecastList(data)
            }
        }

        AnimatedVisibility(visible = dailyForecasts is BaseModel.Loading) {
            LoadingState()
        }
    }
}

@Composable
fun WeatherHeader(
    locationName: String,
    country: String,
    onBackClick: () -> Unit
) {
    Row(modifier = Modifier.padding(vertical = 32.dp)) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .clickable { onBackClick() },
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(
                text = locationName,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Text(country, color = Color.Gray)
        }
    }
}

@Composable
fun TemperatureDisplay(temp: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$temp°",
            fontWeight = FontWeight.Bold,
            fontSize = 80.sp,
            color = Color.White,
            fontFamily = russoFont
        )
    }
}

@Composable
fun ForecastSectionTitle(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color.White
    )
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun HourlyForecastList(forecasts: List<HourlyForecastViewEntity>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(forecasts) { forecast ->
            Column(
                modifier = Modifier
                    .size(100.dp, 140.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.secondary),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val time = forecast.epochDateTime?.let {
                    SimpleDateFormat("H a", Locale.getDefault()).format(Date(it * 1000))
                } ?: "N/A"

                Text(
                    text = time,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://developer.accuweather.com/sites/default/files/${forecast.weatherIcon.fixIcon()}-s.png")
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(70.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${forecast.temperature}°",
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun DailyForecastList(forecasts: List<DailyForecastViewEntity>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(forecasts) { forecast ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = forecast.dateFormatted,
                    color = Color.White
                )

                Row {
                    Icon(
                        Icons.Sharp.ArrowDownward,
                        tint = Color(0xffff5353),
                        contentDescription = null
                    )
                    Text("${forecast.minTemp}°", color = Color.White)
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        Icons.Sharp.ArrowUpward,
                        tint = Color(0xff2eff8c),
                        contentDescription = null
                    )
                    Text("${forecast.maxTemp}°", color = Color.White)
                }

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://developer.accuweather.com/sites/default/files/${forecast.dayIcon.fixIcon()}-s.png")
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(70.dp)
                )
            }
        }
    }
}

@Composable
fun LoadingState() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(color = Color.White)
    }
}

fun Int?.fixIcon(): String {
    return this?.let { if (it < 10) "0$it" else "$it" } ?: "01"
}
