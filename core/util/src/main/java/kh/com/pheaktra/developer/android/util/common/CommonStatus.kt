package kh.com.pheaktra.developer.android.util.common

enum class ValueYN(val value: String) {
    YES("Y"),
    NO("N")
}

enum class ConnectionState {
    Available, Unavailable
}

enum class AirplaneModeState {
    ON,
    OFF
}

enum class ChargingSource {
    USB,
    AC,
    WIRELESS,
    DOCK,
    UNKNOWN
}
