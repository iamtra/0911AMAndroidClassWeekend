package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.notification

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.NotificationResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.NotificationType

class NotificationRepository {
    private val notificationList = listOf(
        NotificationResponse(
            notificationId = "notif_001",
            title = "New Message",
            message = "John Doe sent you a message: \"Hey, are you available?\"",
            type = NotificationType.MESSAGE,
            isRead = false,
            timestamp = "2024-01-15T08:30:00Z",
            senderName = "John Doe",
            senderAvatar = "https://avatar.com/johndoe.jpg"
        ),
        NotificationResponse(
            notificationId = "notif_002",
            title = "Post Liked",
            message = "Sarah Smith liked your photo.",
            type = NotificationType.LIKE,
            isRead = true,
            timestamp = "2024-01-15T07:45:00Z",
            senderName = "Sarah Smith",
            senderAvatar = "https://avatar.com/sarahsmith.jpg"
        ),
        NotificationResponse(
            notificationId = "notif_003",
            title = "New Comment",
            message = "Mike Johnson commented on your post: \"Great shot!\"",
            type = NotificationType.COMMENT,
            isRead = false,
            timestamp = "2024-01-15T07:00:00Z",
            senderName = "Mike Johnson",
            senderAvatar = "https://avatar.com/mikejohnson.jpg"
        ),
        NotificationResponse(
            notificationId = "notif_004",
            title = "New Follower",
            message = "Emily Davis started following you.",
            type = NotificationType.FOLLOW,
            isRead = false,
            timestamp = "2024-01-15T06:30:00Z",
            senderName = "Emily Davis",
            senderAvatar = "https://avatar.com/emilydavis.jpg"
        ),
        NotificationResponse(
            notificationId = "notif_005",
            title = "You were Mentioned",
            message = "Chris Lee mentioned you in a comment: \"@you check this out!\"",
            type = NotificationType.MENTION,
            isRead = true,
            timestamp = "2024-01-14T22:15:00Z",
            senderName = "Chris Lee",
            senderAvatar = "https://avatar.com/chrislee.jpg"
        ),
        NotificationResponse(
            notificationId = "notif_006",
            title = "System Update",
            message = "App updated to version 2.1.0. Check out the new features!",
            type = NotificationType.SYSTEM,
            isRead = false,
            timestamp = "2024-01-14T20:00:00Z",
            senderName = "System",
            senderAvatar = null
        ),
        NotificationResponse(
            notificationId = "notif_007",
            title = "Special Offer",
            message = "You have a 50% discount on premium plan. Limited time only!",
            type = NotificationType.PROMOTION,
            isRead = true,
            timestamp = "2024-01-14T18:30:00Z",
            senderName = "Promotions",
            senderAvatar = null
        ),
        NotificationResponse(
            notificationId = "notif_008",
            title = "Reminder",
            message = "Don't forget your meeting with the team at 3:00 PM today.",
            type = NotificationType.REMINDER,
            isRead = false,
            timestamp = "2024-01-14T17:00:00Z",
            senderName = "Reminder",
            senderAvatar = null
        ),
        NotificationResponse(
            notificationId = "notif_009",
            title = "New Message",
            message = "Anna White sent you a message: \"Can we reschedule?\"",
            type = NotificationType.MESSAGE,
            isRead = true,
            timestamp = "2024-01-14T15:45:00Z",
            senderName = "Anna White",
            senderAvatar = "https://avatar.com/annawhite.jpg"
        ),
        NotificationResponse(
            notificationId = "notif_010",
            title = "Post Liked",
            message = "David Brown liked your video.",
            type = NotificationType.LIKE,
            isRead = false,
            timestamp = "2024-01-14T14:00:00Z",
            senderName = "David Brown",
            senderAvatar = "https://avatar.com/davidbrown.jpg"
        ),
        NotificationResponse(
            notificationId = "notif_011",
            title = "New Comment",
            message = "Olivia Martin commented: \"This is so inspiring!\"",
            type = NotificationType.COMMENT,
            isRead = false,
            timestamp = "2024-01-14T12:30:00Z",
            senderName = "Olivia Martin",
            senderAvatar = "https://avatar.com/oliviamartin.jpg"
        ),
        NotificationResponse(
            notificationId = "notif_012",
            title = "New Follower",
            message = "James Wilson started following you.",
            type = NotificationType.FOLLOW,
            isRead = true,
            timestamp = "2024-01-14T11:00:00Z",
            senderName = "James Wilson",
            senderAvatar = "https://avatar.com/jameswilson.jpg"
        ),
        NotificationResponse(
            notificationId = "notif_013",
            title = "You were Mentioned",
            message = "Sophia Taylor mentioned you in a post.",
            type = NotificationType.MENTION,
            isRead = false,
            timestamp = "2024-01-14T09:45:00Z",
            senderName = "Sophia Taylor",
            senderAvatar = "https://avatar.com/sophiataylor.jpg"
        ),
        NotificationResponse(
            notificationId = "notif_014",
            title = "Security Alert",
            message = "A new login was detected from a new device. Was this you?",
            type = NotificationType.SYSTEM,
            isRead = false,
            timestamp = "2024-01-14T08:00:00Z",
            senderName = "System",
            senderAvatar = null
        ),
        NotificationResponse(
            notificationId = "notif_015",
            title = "Flash Sale",
            message = "Flash sale starts now! Get 30% off on all premium features.",
            type = NotificationType.PROMOTION,
            isRead = true,
            timestamp = "2024-01-13T20:00:00Z",
            senderName = "Promotions",
            senderAvatar = null
        ),
        NotificationResponse(
            notificationId = "notif_016",
            title = "Reminder",
            message = "Your subscription renews in 3 days. Review your plan.",
            type = NotificationType.REMINDER,
            isRead = false,
            timestamp = "2024-01-13T18:00:00Z",
            senderName = "Reminder",
            senderAvatar = null
        ),
        NotificationResponse(
            notificationId = "notif_017",
            title = "New Message",
            message = "Liam Anderson sent you a voice message.",
            type = NotificationType.MESSAGE,
            isRead = true,
            timestamp = "2024-01-13T16:30:00Z",
            senderName = "Liam Anderson",
            senderAvatar = "https://avatar.com/liamanderson.jpg"
        ),
        NotificationResponse(
            notificationId = "notif_018",
            title = "Post Liked",
            message = "Emma Thomas and 12 others liked your post.",
            type = NotificationType.LIKE,
            isRead = false,
            timestamp = "2024-01-13T14:00:00Z",
            senderName = "Emma Thomas",
            senderAvatar = "https://avatar.com/emmathomas.jpg"
        ),
        NotificationResponse(
            notificationId = "notif_019",
            title = "New Comment",
            message = "Noah Jackson replied to your comment: \"Totally agree!\"",
            type = NotificationType.COMMENT,
            isRead = true,
            timestamp = "2024-01-13T11:15:00Z",
            senderName = "Noah Jackson",
            senderAvatar = "https://avatar.com/noahjackson.jpg"
        ),
        NotificationResponse(
            notificationId = "notif_020",
            title = "New Follower",
            message = "Mia Harris started following you.",
            type = NotificationType.FOLLOW,
            isRead = false,
            timestamp = "2024-01-13T09:00:00Z",
            senderName = "Mia Harris",
            senderAvatar = "https://avatar.com/miaharris.jpg"
        ),
    )

    fun getNotificationList(): List<NotificationResponse> {
        return notificationList
    }
}