package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.hardware

import kh.com.pheaktra.developer.android.util.common.ChargingSource

data class BatteryState(
    val level: Int = 0,
    val isCharging: Boolean = false,
    val isFullyCharged: Boolean = false,
    val chargingSource: ChargingSource = ChargingSource.UNKNOWN
)