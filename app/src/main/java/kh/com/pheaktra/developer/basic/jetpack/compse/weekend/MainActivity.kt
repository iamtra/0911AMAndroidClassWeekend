package kh.com.pheaktra.developer.basic.jetpack.compse.weekend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.navigation.AppNavigation
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.LoadingContent
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.LoadingUtil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaseTheme {
                if (LoadingUtil.isLoading.value) {
                    LoadingContent()
                }
                AppNavigation()
            }
        }
    }

    override fun onPause() {
        super.onPause()
//        println("====> onPause")
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
//        println("====> onUserLeaveHint")
    }

    override fun onStop() {
        super.onStop()
//        println("====> onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
//        println("====> onDestroy")
    }
}

