package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.LoadingUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHome(
    homeVM: HomeVM = HomeVM(),
    onClickNotification: () -> Unit = {}
) {
    val messageUiState by homeVM.messageUiState.collectAsStateWithLifecycle()

    LaunchedEffect(messageUiState) {
        when(val state = messageUiState) {
            is BaseUiState.Loading, BaseUiState.None -> LoadingUtil.showLoading()

            is BaseUiState.Error -> {
                LoadingUtil.hideLoading()
                println("Error: ${state.message}")
            }

            is BaseUiState.Success -> LoadingUtil.hideLoading()

            is BaseUiState.ErrorException -> {
                LoadingUtil.hideLoading()
                println("Error: ${state.message}")
            }

        }
    }

    Scaffold(
        modifier = Modifier
            .navigationBarsPadding(),
        topBar = {
            TopAppBar(
                title = {
                    Text("My App")
                },
                actions = {
                    IconButton(
                        onClick = onClickNotification
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notifications_none),
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
    ) { paddingValues ->
        when(val state = messageUiState) {
            is BaseUiState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxWidth()
                ) {
                    items(state.data.size) {
                        Row(
                            modifier = Modifier
                                .height(56.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = state.data[it],
                            )
                        }
                        HorizontalDivider()
                    }
                }
            }

            else -> {}
        }
    }
}


@Composable
@Preview(showBackground = true)
fun ScreenHomePreview() {
    BaseTheme {
        ScreenHome()
    }
}