package kh.com.pheaktra.developer.basic.jetpack.compse.weekend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.HomeScreen
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenAccount
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenCardView
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenCarousel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenCheckBox
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenChip
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenDatePicker
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenAlertDialog
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenBottomBar
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenBottomBarWithFloating
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenBottomNavigationBar
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenBottomSheet
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenCircleProgressIndicator
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenDialog
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenInvoice
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenMenu
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenNavigationDrawer
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenRadio
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenSlider
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenSnackbar
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenSwitch
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenTabs
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenTextFiled
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen.ScreenToolsTips


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
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
            ScreenAccount()
        }
    }
}

