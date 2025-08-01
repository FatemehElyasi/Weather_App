package ir.fatemelyasii.weather.view.screens.homeScreen

import android.R.string
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.fatemelyasii.weather.R
import ir.fatemelyasii.weather.model.di.NetworkModule
import ir.fatemelyasii.weather.model.di.NetworkModule.Companion.API_BASE_URL_ICON_QUALIFIER
import ir.fatemelyasii.weather.model.viewEntity.LocationViewEntity
import ir.fatemelyasii.weather.view.utils.baseModel.BaseModel
import kotlinx.coroutines.CoroutineExceptionHandler
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent.inject
import kotlin.jvm.java

@Composable
fun HomeScreen(
    navigateToWeather: (LocationViewEntity) -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {
    val locations by viewModel.locations.collectAsState()
    val city by viewModel.city.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 16.dp,
                vertical = 64.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.welcome_text),
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .height(55.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondary),
            contentAlignment = Alignment.Center
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .focusable(),
                value = city,
                singleLine = true,
                onValueChange = { viewModel.setCity(it) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                ), placeholder = {
                    Text(
                        stringResource(R.string.city_text)
                    )
                }
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        AnimatedVisibility(
            visible = locations is BaseModel.Success,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            Column {
                Text(
                    text = stringResource(R.string.choose_city),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))

                when (val data = locations) {
                    is BaseModel.Success -> {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(data.data) { location ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(50.dp)
                                        .clip(
                                            RoundedCornerShape(8.dp)
                                        )
                                        .background(MaterialTheme.colorScheme.secondary)
                                        .clickable {
                                            navigateToWeather(
                                                LocationViewEntity(
                                                    key = location.key,
                                                    englishName = location.englishName,
                                                    countryName = location.countryName
                                                )
                                            )
                                        }
                                        .padding(8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically) {
                                    Column {
                                        Text(
                                            location.englishName.orEmpty(),
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            location.countryName.orEmpty(),
                                            color = Color.Gray,
                                            fontSize = 12.sp
                                        )
                                    }
                                }
                            }
                        }
                    }

                    else -> {}
                }
            }
        }
        AnimatedVisibility(
            visible = locations is BaseModel.Loading,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            CircularProgressIndicator(color = Color.White)
        }
    }
}