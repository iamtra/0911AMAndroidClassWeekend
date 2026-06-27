package kh.com.pheaktra.developer.basic.jetpack.compse.weekend

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.app.ActivityCompat
import dagger.hilt.android.AndroidEntryPoint
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.navigation.AppNavigation
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.LoadingContent
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.LoadingUtil
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.NotificationUtil

/**
 * Setup DI for android project
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private var route by mutableStateOf<String?>(null)
    private var userId by mutableStateOf<String?>(null)

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        route = intent?.getStringExtra("route")
        userId = intent?.getStringExtra("userId")

        println("=====> $route")
        println("=====> $userId")

        enableEdgeToEdge()
        setContent {
            val notificationPermissionLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission()
            ) { isGranted ->
                if (!isGranted) {
                    Toast.makeText(this@MainActivity, "Permission Denied", Toast.LENGTH_SHORT).show()
                } else {
                    NotificationUtil.createNotificationChannel(this@MainActivity)
                }
            }

            LaunchedEffect(Unit) {
                // Check grant notification
                if (
                    ActivityCompat.checkSelfPermission(
                        this@MainActivity,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                }
            }

            BaseTheme {
                if (LoadingUtil.isLoading.value) {
                    LoadingContent()
                }
                AppNavigation(route)
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

/**
 * 1. APK
 * 2. AAB (app bundle)
 * 3. AAR (android archive)
 */
