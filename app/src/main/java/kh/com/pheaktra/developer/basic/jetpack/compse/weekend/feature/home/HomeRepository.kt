package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.base.ComponentModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.navigation.*

private val componentList = mutableListOf(
    ComponentModel(
        1,
        "Buttons",
        "Explore different button styles and interactions in Jetpack Compose.",
        "https://img.icons8.com/fluency/48/button.png",
        Button
    ),
    ComponentModel(
        2,
        "Card View",
        "Display content inside elegant and reusable card layouts.",
        "https://img.icons8.com/fluency/48/cards.png",
        CardView
    ),
    ComponentModel(
        3,
        "Checkbox",
        "Handle single and multiple selection using checkboxes.",
        "https://img.icons8.com/fluency/48/checked-checkbox.png",
        CheckBox
    ),
    ComponentModel(
        4,
        "Radio Button",
        "Allow users to select one option from multiple choices.",
        "https://img.icons8.com/fluency/48/loading.png",
        Radio
    ),
    ComponentModel(
        5,
        "Switch",
        "Toggle settings and preferences with switch controls.",
        "https://img.icons8.com/fluency/48/toggle-on.png",
        Switch
    ),
    ComponentModel(
        6,
        "Slider",
        "Select values interactively using a customizable slider.",
        "https://img.icons8.com/fluency/48/loading.png",
        Slider
    ),
    ComponentModel(
        7,
        "Chip",
        "Compact elements for filtering, tags, and selections.",
        "https://img.icons8.com/fluency/48/loading.png",
        Chip
    ),
    ComponentModel(
        8,
        "Dialog",
        "Show custom dialog windows with Compose UI.",
        "https://img.icons8.com/fluency/48/chat-message.png",
        Dialog
    ),
    ComponentModel(
        9,
        "Alert Dialog",
        "Display important alerts, confirmations, and actions.",
        "https://img.icons8.com/fluency/48/error.png",
        AlertDialog
    ),
    ComponentModel(
        10,
        "Bottom Sheet",
        "Present modal and persistent bottom sheet layouts.",
        "https://img.icons8.com/fluency/48/swipe-up.png",
        BottomSheet
    ),
    ComponentModel(
        11,
        "Snackbar",
        "Show temporary feedback messages with actions.",
        "https://img.icons8.com/fluency/48/info.png",
        Snackbar
    ),
    ComponentModel(
        12,
        "Tooltip",
        "Provide quick hints and contextual information.",
        "https://img.icons8.com/fluency/48/help.png",
        Tooltip
    ),
    ComponentModel(
        13,
        "Menu",
        "Create dropdown and popup menu components.",
        "https://img.icons8.com/fluency/48/menu-2.png",
        Menu
    ),
    ComponentModel(
        14,
        "Navigation Drawer",
        "Implement side navigation drawers for app navigation.",
        "https://img.icons8.com/fluency/48/sidebar-menu.png",
        NavigationDrawer
    ),
    ComponentModel(
        15,
        "Bottom Navigation",
        "Build bottom navigation for multi-screen applications.",
        "https://img.icons8.com/fluency/48/bottom-navigation-toolbar.png",
        BottomNavigationBar
    ),
    ComponentModel(
        16,
        "Bottom Bar + FAB",
        "Combine bottom navigation with floating action buttons.",
        "https://img.icons8.com/fluency/48/loading.png",
        BottomBarWithFloating
    ),
    ComponentModel(
        17,
        "Circular Progress",
        "Display loading states with circular progress indicators.",
        "https://img.icons8.com/fluency/48/loading.png",
        CircleProgressIndicator
    ),
    ComponentModel(
        18,
        "Carousel",
        "Create swipeable image and content carousels.",
        "https://img.icons8.com/fluency/48/image-gallery.png",
        Carousel
    ),
    ComponentModel(
        19,
        "Date Picker",
        "Allow users to pick and manage dates easily.",
        "https://img.icons8.com/fluency/48/calendar.png",
        DatePicker
    ),
    ComponentModel(
        20,
        "Tabs",
        "Organize content using customizable tab layouts.",
        "https://img.icons8.com/fluency/48/tab.png",
        Tabs
    ),
    ComponentModel(
        21,
        "Text Field",
        "Capture and validate user input with text fields.",
        "https://img.icons8.com/fluency/48/edit-property.png",
        TextField
    ),
    ComponentModel(
        22,
        "Bottom App Bar",
        "Implement Material 3 bottom app bar designs.",
        "https://img.icons8.com/fluency/48/toolbar.png",
        BottomBar
    ),
    ComponentModel(
        23,
        "Account Profile",
        "Design beautiful account and profile UI screens.",
        "https://img.icons8.com/fluency/48/user-male-circle.png",
        Account
    ),
    ComponentModel(
        24,
        "Invoice UI",
        "Build modern invoice and payment summary screens.",
        "https://img.icons8.com/fluency/48/invoice.png",
        Invoice
    ),
    ComponentModel(
        25,
        "User API",
        "Fetch and display remote API data using Retrofit.",
        "https://img.icons8.com/fluency/48/api-settings.png",
        UserApi
    ),
    ComponentModel(
        26,
        "Push NotificationUtil",
        "Create and display local push notifications.",
        "https://img.icons8.com/fluency/48/appointment-reminders.png",
        PostNotification
    ),
    ComponentModel(
        27,
        "Select Single Photo",
        "Pick and preview a single image from device storage.",
        "https://img.icons8.com/fluency/48/picture.png",
        SelectedSinglePhoto
    ),
    ComponentModel(
        28,
        "Select Multiple Photos",
        "Choose and display multiple images from gallery.",
        "https://img.icons8.com/fluency/48/pictures-folder.png",
        SelectedMultiplePhotos
    ),
    ComponentModel(
        29,
        "Select Single Video",
        "Pick and preview a single video file from storage.",
        "https://img.icons8.com/fluency/48/video.png",
        SelectedSingleVideo
    ),
    ComponentModel(
        30,
        "Select Multiple Videos",
        "Select and manage multiple video files easily.",
        "https://img.icons8.com/fluency/48/video-gallery.png",
        SelectedMultipleVideo
    ),
    ComponentModel(
        31,
        "Select Videos & Photos",
        "Pick and preview both images and videos from device storage.",
        "https://img.icons8.com/fluency/48/media-queries.png",
        SelectedVideosAndPhotos
    ),
    ComponentModel(
        32,
        "Camera Launcher",
        "Pick and preview both images and videos from device storage.",
        "https://img.icons8.com/fluency/48/media-queries.png",
        CameraLauncher
    ),
    ComponentModel(
        id = 33,
        title = "Room Database",
        message = "Local SQLite database powered by Room for storing, querying, updating, and managing app data with reactive Flow support.",
        icon = "https://img.icons8.com/color/96/database.png",
        key = RoomDatabase
    ),
    ComponentModel(
        id = 34,
        title = "Get Location",
        message = "Access the device's current location using runtime permissions and the Fused Location Provider to retrieve latitude and longitude coordinates.",
        icon = "https://img.icons8.com/color/96/marker.png",
        key = GetLocation
    ),
    ComponentModel(
        35,
        "AndroidX Camera",
        "Capture photos using CameraX with a custom camera preview, permission handling, and capture controls.",
        "https://img.icons8.com/fluency/48/media-queries.png",
        AndroidXCamera
    ),
    ComponentModel(
        36,
        "Internet State",
        "Monitor internet connectivity in real time and detect when the device connects to or disconnects from the network.",
        "https://img.icons8.com/color/96/wifi.png",
        InternetStateChange
    ),

    ComponentModel(
        37,
        "Screen Information",
        "Display detailed device screen information, including resolution, dimensions, density, physical size, aspect ratio, and brightness settings.",
        "https://img.icons8.com/color/96/monitor.png",
        DeviceScreenInformation
    ),

    ComponentModel(
        38,
        "Fingerprint Sensor",
        "Detect fingerprint sensor availability, check biometric enrollment status, and verify whether fingerprint authentication is supported on the device.",
        "https://img.icons8.com/color/96/fingerprint.png",
        Biometric
    ),

    ComponentModel(
        39,
        "Airplane Mode Broadcast",
        "Monitor airplane mode changes in real time and detect when the user turns airplane mode on or off.",
        "https://img.icons8.com/color/96/airplane-mode-on.png",
        AirPlanMode
    ),

    ComponentModel(
        40,
        "Battery Broadcast",
        "Monitor battery status changes in real time, including battery level, charging state, and power connection events.",
        "https://img.icons8.com/color/96/battery.png",
        Battery
    )
)

class HomeRepository {

    fun getMessage(): Flow<List<ComponentModel>> {
        return flow {
            emit(componentList)
        }
    }
}
