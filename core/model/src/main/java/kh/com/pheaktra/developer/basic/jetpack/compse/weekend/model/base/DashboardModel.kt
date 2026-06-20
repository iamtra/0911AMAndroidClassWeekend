package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.base

data class DashboardModel(
    val id: String,
    val label: String,
    val iconRes: Int,
    val isEnabled: Boolean = true
)
