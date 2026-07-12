package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.runtime.mutableIntStateOf
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
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.extension.toBatteryState

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun ScreenBattery(
    onBack: () -> Unit = {}
) {
    val context = LocalContext.current
    var batteryLevel by remember { mutableIntStateOf(100) }
    var chargingStatus by remember { mutableStateOf(false) }

    DisposableEffect(context) {
        val receiver = object : BroadcastReceiver() {
            @RequiresApi(Build.VERSION_CODES.S)
            override fun onReceive(
                context: Context?,
                intent: Intent?
            ) {
                if (intent?.action != Intent.ACTION_BATTERY_CHANGED) {
                    return
                }

                val batteryState = intent.toBatteryState()
                batteryLevel = batteryState.level
                chargingStatus = batteryState.isCharging
            }
        }

        val filter = IntentFilter(
            Intent.ACTION_BATTERY_CHANGED
        )

        val initialBatteryIntent =
            ContextCompat.registerReceiver(
                context,
                receiver,
                filter,
                ContextCompat.RECEIVER_EXPORTED
            )

        // ACTION_BATTERY_CHANGED is a sticky broadcast.
        // This provides the current battery state immediately.
        initialBatteryIntent?.let { intent ->
            val batteryState = intent.toBatteryState()
            batteryLevel = batteryState.level
            chargingStatus = batteryState.isCharging
        }

        onDispose {
            runCatching {
                context.unregisterReceiver(receiver)
            }
        }
    }

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("Battery")
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
            Item(label = "Battery Level", value = "$batteryLevel%")
            val status = if (chargingStatus) "Charging" else "Not charging"
            Item(label = "Charging Status", value = status)
        }
    }
}

@Composable
fun Item(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label)
        Text(value)
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Composable
@Preview
fun ScreenBatteryPreview() {
    BaseTheme {
        ScreenBattery()
    }
}