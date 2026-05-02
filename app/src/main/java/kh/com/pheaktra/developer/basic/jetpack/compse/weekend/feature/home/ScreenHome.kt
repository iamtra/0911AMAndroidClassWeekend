package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home

import android.widget.Toast
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.LoadingUtil
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHome(
    homeVM: HomeVM = HomeVM(),
    onClickNotification: () -> Unit = {},
    onClickItem: (Any) -> Unit = {}
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val componentListState by homeVM.componentList.collectAsStateWithLifecycle()

    LaunchedEffect(componentListState) {
        when (val state = componentListState) {
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

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> {
//                    println("====> ON_CREATE")
                }

                Lifecycle.Event.ON_START -> {
//                    println("====> ON_START")
                }

                Lifecycle.Event.ON_RESUME -> {
//                    println("====> ON_RESUME")
                    scope.launch {
                        Toast.makeText(context, "Compose is on resume", Toast.LENGTH_SHORT).show()
                    }
                }

                Lifecycle.Event.ON_PAUSE -> {
//                    println("====> ON_PAUSE")
                }

                Lifecycle.Event.ON_STOP -> {
//                    println("====> ON_STOP")
                }

                Lifecycle.Event.ON_DESTROY -> {
//                    println("====> ON_DESTROY")
                }

                Lifecycle.Event.ON_ANY -> {
//                    println("====> ON_ANY")
                }
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
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
        when (val state = componentListState) {
            is BaseUiState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxWidth()
                ) {
                    items(state.data.size) { index ->
                        val item = state.data[index]
                        Row(
                            modifier = Modifier
                                .height(56.dp)
                                .fillMaxWidth()
                                .clickable {
                                    onClickItem(item.key)
                                }
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                model = item.icon,
                                contentDescription = null,
                                modifier = Modifier.padding(end = 16.dp)
                            )
                            Text(
                                text = item.title,
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