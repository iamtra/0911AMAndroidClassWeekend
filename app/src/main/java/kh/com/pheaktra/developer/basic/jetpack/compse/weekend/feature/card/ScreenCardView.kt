package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.card

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.CardModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.LoadingUtil

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
fun ScreenCardView(
    cardVM: CardVM = CardVM(),
    onBack: () -> Unit = {}
) {
    val cardListUiState by cardVM.cardListUiState.collectAsStateWithLifecycle()

    val isPressed = remember { mutableStateOf(false) }
    val scale by animateFloatAsState(if (isPressed.value) 0.95f else 1f)

    LaunchedEffect(cardListUiState) {
        when (val state = cardListUiState) {
            is BaseUiState.Loading, BaseUiState.None -> LoadingUtil.showLoading()
            is BaseUiState.Success -> LoadingUtil.hideLoading()
            is BaseUiState.Error -> {
                LoadingUtil.hideLoading()
                println("Error: ${state.message}")
            }

            is BaseUiState.ErrorException -> {
                LoadingUtil.hideLoading()
                println("Error: ${state.message}")
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                           onBack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Menu Icon"
                        )
                    }
                },
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Screen Card",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W900,
                        fontStyle = FontStyle.Normal
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.purple_200),
                    actionIconContentColor = Color.Blue,
                    titleContentColor = Color.DarkGray
                )
            )
        }
    ) { paddingValues ->
        when (val state = cardListUiState) {
            is BaseUiState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(top = 12.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(state.data.size, key = { state.data[it].cardId }) { index ->
                        CardItem(card = state.data[index])
                    }
                }
            }

            else -> {}
        }
    }
}

@Composable
fun CardItem(card: CardModel) {

    val isPressed = remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isPressed.value) 0.95f else 1f,
        label = "scale_animation"
    )

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(16.dp)
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> isPressed.value = true
                    MotionEvent.ACTION_UP,
                    MotionEvent.ACTION_CANCEL -> isPressed.value = false
                }
                false
            }
            .clickable {
                // TODO: handle click
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.elevatedCardElevation(),
        shape = RoundedCornerShape(
            topEnd = 24.dp,
            bottomStart = 24.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Column {
                Text(
                    text = card.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = card.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenCardViewPreview() {
    ScreenCardView()
}