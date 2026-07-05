package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.navigation

import android.net.Uri
import kh.com.pheaktra.developer.android.domain.model.TaskModel
import kotlinx.serialization.Serializable

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
data object UserApi
data object PostNotification
data object SelectedSinglePhoto
data object SelectedMultiplePhotos

data object SelectedSingleVideo
data object SelectedMultipleVideo

data object SelectedVideosAndPhotos

data object CameraLauncher

data object RoomDatabase

@Serializable
data class CreateTask(val task: TaskModel? = null)

data object GetLocation
data object AndroidXCamera
data object CameraAndroidPreview

@Serializable
data class PreviewImage(
    val imageUri: String
)