package kh.com.pheaktra.developer.basic.jetpack.compse.weekend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.components.ScreenAccount
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home.ScreenHome
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaseTheme {
//            HomeScreen()
//            ScreenCardView()
//            ScreenCarousel()
//            ScreenCheckBox()
//            ScreenChip()
//            ScreenDatePicker()
//            ScreenAlertDialog()
//            ScreenDialog()
//            ScreenCircleProgressIndicator()
//            ScreenMenu()
//            ScreenBottomNavigationBar()
//            ScreenNavigationDrawer()
//            ScreenRadio()
//            ScreenBottomSheet()
//            ScreenSlider()
//            ScreenSnackbar()
//            ScreenSwitch()
//            ScreenTabs()
//            ScreenTextFiled()
//            ScreenBottomBar()
//            ScreenBottomBarWithFloating()
//            ScreenToolsTips()
//            ScreenInvoice()
//                ScreenAccount()
                ScreenHome()

            }
        }
    }
}

