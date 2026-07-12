package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import kh.com.pheaktra.developer.android.util.common.AirplaneModeState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.extension.isAirplaneModeEnabled

@Composable
fun ScreenAirPlanMode(
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val applicationContext = context.applicationContext

    var airplaneModeState by remember {
        mutableStateOf(
            if (applicationContext.isAirplaneModeEnabled()) {
                AirplaneModeState.ON
            } else {
                AirplaneModeState.OFF
            }
        )
    }

    DisposableEffect(applicationContext) {
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(
                context: Context?,
                intent: Intent?
            ) {
                if (intent?.action != Intent.ACTION_AIRPLANE_MODE_CHANGED) {
                    return
                }

                val isEnabled = intent.getBooleanExtra(
                    "state",
                    applicationContext.isAirplaneModeEnabled()
                )

                airplaneModeState = if (isEnabled) {
                    AirplaneModeState.ON
                } else {
                    AirplaneModeState.OFF
                }
            }
        }

        val intentFilter = IntentFilter(
            Intent.ACTION_AIRPLANE_MODE_CHANGED
        )

        ContextCompat.registerReceiver(
            applicationContext,
            receiver,
            intentFilter,
            ContextCompat.RECEIVER_EXPORTED
        )

        onDispose {
            applicationContext.unregisterReceiver(receiver)
        }
    }
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("Fingerprint")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBack()
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = null
                        )
                    }
                }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val status = when (airplaneModeState) {
                    AirplaneModeState.ON -> {
                        "Airplane mode is turned on"
                    }
                    AirplaneModeState.OFF -> {
                        "Airplane mode is turned off"
                    }
                }
                Text("Biometric status")
                Text(status)
            }
        }
    }
}

@Preview
@Composable
fun ScreenAirPlanModePreview() {
    BaseTheme {
        ScreenAirPlanMode(
            onBack = {}
        )
    }
}