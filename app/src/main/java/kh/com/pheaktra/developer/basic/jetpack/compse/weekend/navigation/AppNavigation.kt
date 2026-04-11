package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home.ScreenHome
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.notification.ScreenNotification

// Define keys that will identify content
data object Home
data object Notification

@Composable
fun AppNavigation() {

    val backStack = remember { mutableStateListOf<Any>(Home) }

    fun onBack() {
        backStack.removeLastOrNull()
    }

    NavDisplay(
        backStack = backStack,
        onBack = { onBack() },
        entryProvider = { key ->
            when (key) {
                is Home -> NavEntry(key) {
                    ScreenHome(
                        onClickNotification = {
                            backStack.add(Notification)
                        }
                    )
                }

                is Notification -> NavEntry(key) {
                    ScreenNotification(
                        onBack = {
                            onBack()
                        }
                    )
                }

                else -> NavEntry(Unit) { Text("Unknown route") }
            }
        }
    )
}