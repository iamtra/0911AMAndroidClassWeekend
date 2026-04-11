package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.notification

import androidx.lifecycle.ViewModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.NotificationResponse
import kotlinx.coroutines.flow.MutableStateFlow

class NotificationVM(
    private val notificationRepository: NotificationRepository = NotificationRepository()
) : ViewModel() {
    private var _notificationList: MutableStateFlow<List<NotificationResponse>> = MutableStateFlow(emptyList())
    var notificationList = _notificationList

    fun getNotificationList() {
        _notificationList.value = notificationRepository.getNotificationList()
    }
}