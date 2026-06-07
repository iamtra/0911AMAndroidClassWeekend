package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.extension

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.common.ValueYN
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun String.formatTimestamp(): String {
    return try {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        val date = sdf.parse(this) ?: return this
        val now = Date()
        val diff = now.time - date.time
        when {
            diff < 60_000 -> "Just now"
            diff < 3_600_000 -> "${diff / 60_000}m ago"
            diff < 86_400_000 -> "${diff / 3_600_000}h ago"
            diff < 604_800_000 -> "${diff / 86_400_000}d ago"
            else -> SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(date)
        }
    } catch (e: Exception) {
        this
    }
}

fun String.isYes() : Boolean {
    return this.uppercase() == ValueYN.YES.value
}

fun String.isNo() : Boolean {
    return this.uppercase() == ValueYN.NO.value
}

fun String.toValueYN() : ValueYN {
    return if (this.isYes()) ValueYN.YES else ValueYN.NO
}