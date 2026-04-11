package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class NotificationResponse(
    val notificationId: String,
    val title: String,
    val message: String,
    val type: NotificationType,
    val isRead: Boolean,
    val timestamp: String,
    val senderName: String,
    val senderAvatar: String?,
)

enum class NotificationType {
    MESSAGE,
    LIKE,
    COMMENT,
    FOLLOW,
    MENTION,
    SYSTEM,
    PROMOTION,
    REMINDER
}

fun NotificationType.icon(): ImageVector = when (this) {
    NotificationType.MESSAGE   -> Icons.Default.Notifications
    NotificationType.LIKE      -> Icons.Default.FavoriteBorder
    NotificationType.COMMENT   -> Icons.Default.MailOutline
    NotificationType.FOLLOW    -> Icons.Default.Add
    NotificationType.MENTION   -> Icons.Default.Email
    NotificationType.SYSTEM    -> Icons.Default.Info
    NotificationType.PROMOTION -> Icons.Default.ThumbUp
    NotificationType.REMINDER  -> Icons.Default.Notifications
}

fun NotificationType.color(): Color = when (this) {
    NotificationType.MESSAGE   -> Color(0xFF2196F3)
    NotificationType.LIKE      -> Color(0xFFE91E63)
    NotificationType.COMMENT   -> Color(0xFF4CAF50)
    NotificationType.FOLLOW    -> Color(0xFF9C27B0)
    NotificationType.MENTION   -> Color(0xFFFF9800)
    NotificationType.SYSTEM    -> Color(0xFF607D8B)
    NotificationType.PROMOTION -> Color(0xFFFF5722)
    NotificationType.REMINDER  -> Color(0xFF00BCD4)
}