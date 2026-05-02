package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.ComponentModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.navigation.*

class HomeRepository {
    private val componentList = mutableListOf<ComponentModel>(
        ComponentModel(1, "Button", "Button component", "https://img.icons8.com/fluency/48/button.png", Button),
        ComponentModel(2, "Card View", "Card View component", "https://img.icons8.com/fluency/48/stack-of-cards.png", CardView),
        ComponentModel(3, "CheckBox", "CheckBox component", "https://img.icons8.com/fluency/48/checked-checkbox.png", CheckBox),
        ComponentModel(4, "Radio", "Radio component", "https://img.icons8.com/fluency/48/radio-button.png", Radio),
        ComponentModel(5, "Switch", "Switch component", "https://img.icons8.com/fluency/48/switch-on.png", Switch),
        ComponentModel(6, "Slider", "Slider component", "https://img.icons8.com/fluency/48/slider.png", Slider),
        ComponentModel(7, "Chip", "Chip component", "https://img.icons8.com/fluency/48/chips.png", Chip),
        ComponentModel(8, "Dialog", "Dialog component", "https://img.icons8.com/fluency/48/dialogue.png", Dialog),
        ComponentModel(9, "Alert Dialog", "Alert Dialog component", "https://img.icons8.com/fluency/48/error.png", AlertDialog),
        ComponentModel(10, "Bottom Sheet", "Bottom Sheet component", "https://img.icons8.com/fluency/48/scroll.png", BottomSheet),
        ComponentModel(11, "Snackbar", "Snackbar component", "https://img.icons8.com/fluency/48/info.png", Snackbar),
        ComponentModel(12, "Tooltip", "Tooltip component", "https://img.icons8.com/fluency/48/help.png", Tooltip),
        ComponentModel(13, "Menu", "Menu component", "https://img.icons8.com/fluency/48/menu.png", Menu),
        ComponentModel(14, "Navigation Drawer", "Navigation Drawer component", "https://img.icons8.com/fluency/48/sidebar-menu.png", NavigationDrawer),
        ComponentModel(15, "Bottom Navigation Bar", "Bottom Navigation Bar component", "https://img.icons8.com/fluency/48/bottom-navigation.png", BottomNavigationBar),
        ComponentModel(16, "Bottom Bar With Floating", "Bottom Bar With Floating component", "https://img.icons8.com/fluency/48/plus-key.png", BottomBarWithFloating),
        ComponentModel(17, "Circle Progress Indicator", "Circle Progress Indicator component", "https://img.icons8.com/fluency/48/spinner.png", CircleProgressIndicator),
        ComponentModel(18, "Carousel", "Carousel component", "https://img.icons8.com/fluency/48/image-gallery.png", Carousel),
        ComponentModel(19, "Date Picker", "Date Picker component", "https://img.icons8.com/fluency/48/calendar.png", DatePicker),
        ComponentModel(20, "Tabs", "Tabs component", "https://img.icons8.com/fluency/48/tab.png", Tabs),
        ComponentModel(21, "Text Field", "Text Field component", "https://img.icons8.com/fluency/48/rename.png", TextField),
        ComponentModel(22, "Bottom Bar", "Bottom Bar component", "https://img.icons8.com/fluency/48/toolbar.png", BottomBar),
        ComponentModel(23, "Account", "Account component", "https://img.icons8.com/fluency/48/user-male-circle.png", Account),
        ComponentModel(24, "Invoice", "Invoice component", "https://img.icons8.com/fluency/48/invoice.png", Invoice)
    )

    fun getMessage(): Flow<List<ComponentModel>> {
        return flow {
            emit(componentList)
        }
    }
}
