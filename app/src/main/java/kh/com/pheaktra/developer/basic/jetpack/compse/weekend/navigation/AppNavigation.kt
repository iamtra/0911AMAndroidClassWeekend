package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.account.ScreenAccount
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.alert_dialog.ScreenAlertDialog
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.bottom_bar.ScreenBottomBar
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.bottom_bar_with_floating.ScreenBottomBarWithFloating
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.bottom_navigation_bar.ScreenBottomNavigationBar
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.bottom_sheet.ScreenBottomSheet
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.button.ScreenButton
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.card.ScreenCardView
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.carousel.ScreenCarousel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.checkbox.ScreenCheckBox
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.chip.ScreenChip
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.circle_progress_indicator.ScreenCircleProgressIndicator
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.datepicker.ScreenDatePicker
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.dialog.ScreenDialog
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home.ScreenHome
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.invoice.ScreenInvoice
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.menu.ScreenMenu
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.navigation_drawer.ScreenNavigationDrawer
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.notification.ScreenNotification
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.radio.ScreenRadio
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.slider.ScreenSlider
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.snackbar.ScreenSnackbar
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.switch.ScreenSwitch
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.tab.ScreenTabs
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.textfield.ScreenTextFiled
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.tooltip.ScreenToolsTips

// Define keys that will identify content
data object Home
data object Notification
data object CardView
data object Button
data object CheckBox
data object Radio
data object Switch
data object Slider
data object Chip
data object Dialog
data object AlertDialog
data object BottomSheet
data object Snackbar
data object Tooltip
data object Menu
data object NavigationDrawer
data object BottomNavigationBar
data object BottomBarWithFloating
data object CircleProgressIndicator
data object Carousel
data object DatePicker
data object Tabs
data object TextField
data object BottomBar
data object Account
data object Invoice

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
                        },
                        onClickItem = { itemKey ->
                            backStack.add(itemKey)
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

                is CardView -> NavEntry(key) {
                    ScreenCardView(
                        onBack = {
                            onBack()
                        }
                    )
                }

                is Button -> NavEntry(key) {
                    ScreenButton(
                        onBack = {
                            onBack()
                        }
                    )
                }

                is CheckBox -> NavEntry(key) {
                    ScreenCheckBox()
                }

                is Radio -> NavEntry(key) {
                    ScreenRadio()
                }

                is Switch -> NavEntry(key) {
                    ScreenSwitch()
                }

                is Slider -> NavEntry(key) {
                    ScreenSlider()
                }

                is Chip -> NavEntry(key) {
                    ScreenChip()
                }

                is Dialog -> NavEntry(key) {
                    ScreenDialog()
                }

                is AlertDialog -> NavEntry(key) {
                    ScreenAlertDialog()
                }

                is BottomSheet -> NavEntry(key) {
                    ScreenBottomSheet()
                }

                is Snackbar -> NavEntry(key) {
                    ScreenSnackbar()
                }

                is Tooltip -> NavEntry(key) {
                    ScreenToolsTips(
                        onBack = {
                            onBack()
                        }
                    )
                }

                is Menu -> NavEntry(key) {
                    ScreenMenu()
                }

                is NavigationDrawer -> NavEntry(key) {
                    ScreenNavigationDrawer()
                }

                is BottomNavigationBar -> NavEntry(key) {
                    ScreenBottomNavigationBar()
                }

                is BottomBarWithFloating -> NavEntry(key) {
                    ScreenBottomBarWithFloating()
                }

                is CircleProgressIndicator -> NavEntry(key) {
                    ScreenCircleProgressIndicator()
                }

                is Carousel -> NavEntry(key) {
                    ScreenCarousel()
                }

                is DatePicker -> NavEntry(key) {
                    ScreenDatePicker()
                }

                is Tabs -> NavEntry(key) {
                    ScreenTabs()
                }

                is TextField -> NavEntry(key) {
                    ScreenTextFiled()
                }

                is BottomBar -> NavEntry(key) {
                    ScreenBottomBar()
                }

                is Account -> NavEntry(key) {
                    ScreenAccount(
                        onBack = {
                            onBack()
                        }
                    )
                }

                is Invoice -> NavEntry(key) {
                    ScreenInvoice(
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
