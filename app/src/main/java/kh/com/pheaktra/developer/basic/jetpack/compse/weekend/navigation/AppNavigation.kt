package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.core.net.toUri
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.account.ScreenAccount
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.alertdialog.ScreenAlertDialog
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.androidxcamera.ScreenAndroidXCamera
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.androidxcamera.ScreenCameraView
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.androidxcamera.ScreenPreviewImage
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.bottom_bar.ScreenBottomBar
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.bottom_bar_with_floating.ScreenBottomBarWithFloating
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.bottom_navigation_bar.ScreenBottomNavigationBar
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.bottom_sheet.ScreenBottomSheet
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.button.ScreenButton
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.camera.ScreenCameraLauncher
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.card.ScreenCardView
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.carousel.ScreenCarousel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.checkbox.ScreenCheckBox
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.chip.ScreenChip
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.circle_progress_indicator.ScreenCircleProgressIndicator
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.datepicker.ScreenDatePicker
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.dialog.ScreenDialog
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home.ScreenHome
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.intenetstatechange.ScreenInternetStateChange
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.invoice.ScreenInvoice
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.location.ScreenLocation
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.mediapicker.ScreenSelectedMultiplePhoto
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.mediapicker.ScreenSelectedMultipleVideo
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.mediapicker.ScreenSelectedSinglePhoto
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.mediapicker.ScreenSelectedSingleVideo
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.mediapicker.ScreenSelectedVideosAndPhotos
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.menu.ScreenMenu
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.navigation_drawer.ScreenNavigationDrawer
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.notification.ScreenNotification
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.postnotification.ScreenPostNotification
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.radio.ScreenRadio
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.roomdatabase.ScreenCreateTask
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.roomdatabase.ScreenRoomDatabase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.screenInfomation.ScreenDeviceScreenInformation
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.slider.ScreenSlider
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.snackbar.ScreenSnackbar
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.switch.ScreenSwitch
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.tab.ScreenTabs
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.textfield.ScreenTextFiled
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.tooltip.ScreenToolsTips
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.userapi.ScreenUserApi

private const val ANIMATION_DURATION = 300

// Define keys that will identify content
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun AppNavigation(route: String? = null) {

    val backStack = remember { mutableStateListOf<Any>(Home) }

    fun onBack() {
        backStack.removeLastOrNull()
    }

    LaunchedEffect(route) {
        when (route) {
            "room-db" -> {
                backStack.add(RoomDatabase)
            }

            "notification-detail" -> {
                backStack.add(Notification)
            }

            "user-api" -> {
                backStack.add(UserApi)
            }
        }
    }

    NavDisplay(
        backStack = backStack,
        onBack = { onBack() },
        transitionSpec = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(ANIMATION_DURATION)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { fullWidth -> -fullWidth / 3 },
                animationSpec = tween(ANIMATION_DURATION)
            )
        },

        popTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth / 3 },
                animationSpec = tween(ANIMATION_DURATION)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { fullWidth -> fullWidth },
                animationSpec = tween(ANIMATION_DURATION)
            )
        },
        entryProvider = entryProvider {
            entry<Home> {
                ScreenHome(
                    onClickNotification = {
                        backStack.add(Notification)
                    },
                    onClickItem = { itemKey ->
                        backStack.add(itemKey)
                    }
                )
            }

            entry<Notification> {
                ScreenNotification(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<CardView> {
                ScreenCardView(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<Button> {
                ScreenButton(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<CheckBox> {
                ScreenCheckBox()
            }

            entry<Radio> {
                ScreenRadio()
            }

            entry<Switch> {
                ScreenSwitch()
            }

            entry<Slider> {
                ScreenSlider()
            }

            entry<Chip> {
                ScreenChip()
            }

            entry<Dialog> {
                ScreenDialog()
            }

            entry<AlertDialog> {
                ScreenAlertDialog()
            }

            entry<BottomSheet> {
                ScreenBottomSheet()
            }

            entry<Snackbar> {
                ScreenSnackbar()
            }

            entry<Tooltip> {
                ScreenToolsTips(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<Menu> {
                ScreenMenu()
            }

            entry<NavigationDrawer> {
                ScreenNavigationDrawer()
            }

            entry<BottomNavigationBar> {
                ScreenBottomNavigationBar()
            }

            entry<BottomBarWithFloating> {
                ScreenBottomBarWithFloating()
            }

            entry<CircleProgressIndicator> {
                ScreenCircleProgressIndicator()
            }

            entry<Carousel> {
                ScreenCarousel()
            }

            entry<DatePicker> {
                ScreenDatePicker()
            }

            entry<Tabs> {
                ScreenTabs()
            }

            entry<TextField> {
                ScreenTextFiled()
            }

            entry<BottomBar> {
                ScreenBottomBar()
            }

            entry<Account> {
                ScreenAccount(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<Invoice> {
                ScreenInvoice(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<UserApi> {
                ScreenUserApi(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<PostNotification> {
                ScreenPostNotification(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<SelectedSinglePhoto> {
                ScreenSelectedSinglePhoto(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<SelectedMultiplePhotos> {
                ScreenSelectedMultiplePhoto(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<SelectedSingleVideo> {
                ScreenSelectedSingleVideo(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<SelectedMultipleVideo> {
                ScreenSelectedMultipleVideo(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<SelectedVideosAndPhotos> {
                ScreenSelectedVideosAndPhotos(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<CameraLauncher> {
                ScreenCameraLauncher(
                    onBack = {
                        onBack()
                    }
                )
            }

            entry<RoomDatabase> {
                ScreenRoomDatabase(

                    onBack = {
                        onBack()
                    },
                    onCreateTask = {
                        backStack.add(CreateTask())
                    },
                    onEditTask = { task ->
                        backStack.add(CreateTask(task))
                    }
                )
            }

            entry<CreateTask> { key ->
                ScreenCreateTask(
                    taskData = key.task,

                    onBack = {
                        onBack()
                    }

                )
            }
            entry<GetLocation> {
                ScreenLocation(
                    onBack = {
                        onBack()
                    }
                )
            }
            entry<AndroidXCamera> {
                ScreenAndroidXCamera(
                    onBack = {
                        onBack()
                    },
                    onOpenCamera = {
                        backStack.add(CameraAndroidPreview)
                    }
                )
            }
            entry<CameraAndroidPreview> {
                ScreenCameraView(
                    onClose = {
                        onBack()
                    },
                    onImageCaptured = { imageUri ->
                        backStack.add(PreviewImage(imageUri = imageUri.toString()))
                    }
                )
            }
            entry<PreviewImage> { key ->
                ScreenPreviewImage(
                    imageUri = key.imageUri.toUri(),
                    onBack = {
                        onBack()
                    },
                )
            }

            entry<InternetStateChange> { _ ->
                ScreenInternetStateChange(
                    onBack = {
                        onBack()
                    },
                )
            }

            entry<DeviceScreenInformation> { _ ->
                ScreenDeviceScreenInformation(
                    onBack = {
                        onBack()
                    },
                )
            }
        }
    )
}