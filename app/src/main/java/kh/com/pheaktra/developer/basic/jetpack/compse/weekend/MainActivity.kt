package kh.com.pheaktra.developer.basic.jetpack.compse.weekend

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import dagger.hilt.android.AndroidEntryPoint
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.navigation.AppNavigation
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.LoadingContent
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.LoadingUtil

/**
 * Setup DI for android project
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
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

/**
 * Room Database requirement
 * 1. Setup task management using
 *      - room database
 *      - dependency injection
 *      - viewmodel
 *      - compose
 *      - navigation
 *      - follow MVVM Architecture
 * 2. Get task list
 * 3. Create task
 * 4. Update task
 * 5. Delete task
 * 6. Get task by id
 * 7. Get task by title (search by title)
 * 8. Filter task by status
 * 9. Define model
 *      - taskModel
 *      - taskName
 *      - taskDescription
 *      - taskCompletedYN
 */

