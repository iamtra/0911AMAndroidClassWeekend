package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.extension

import android.content.Intent
import android.os.BatteryManager
import android.os.Build
import androidx.annotation.RequiresApi
import kh.com.pheaktra.developer.android.util.common.ChargingSource
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.hardware.BatteryState
import kotlin.math.roundToInt

@RequiresApi(Build.VERSION_CODES.S)
fun Intent.toBatteryState(): BatteryState {
    val currentLevel = getIntExtra(
        BatteryManager.EXTRA_LEVEL,
        0
    )

    val maximumLevel = getIntExtra(
        BatteryManager.EXTRA_SCALE,
        100
    )

    val percentage = if (maximumLevel > 0) {
        (currentLevel.toFloat() / maximumLevel.toFloat() * 100)
            .roundToInt()
            .coerceIn(0, 100)
    } else {
        0
    }

    val status = getIntExtra(
        BatteryManager.EXTRA_STATUS,
        BatteryManager.BATTERY_STATUS_UNKNOWN
    )

    val pluggedType = getIntExtra(
        BatteryManager.EXTRA_PLUGGED,
        0
    )

    val isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
        status == BatteryManager.BATTERY_STATUS_FULL

    val isFullyCharged =
        status == BatteryManager.BATTERY_STATUS_FULL

    val chargingSource = when (pluggedType) {
        BatteryManager.BATTERY_PLUGGED_USB -> {
            ChargingSource.USB
        }

        BatteryManager.BATTERY_PLUGGED_AC -> {
            ChargingSource.AC
        }

        BatteryManager.BATTERY_PLUGGED_WIRELESS -> {
            ChargingSource.WIRELESS
        }

        BatteryManager.BATTERY_PLUGGED_DOCK -> {
            ChargingSource.DOCK
        }

        else -> {
            ChargingSource.UNKNOWN
        }
    }

    return BatteryState(
        level = percentage,
        isCharging = isCharging,
        isFullyCharged = isFullyCharged,
        chargingSource = chargingSource
    )
}