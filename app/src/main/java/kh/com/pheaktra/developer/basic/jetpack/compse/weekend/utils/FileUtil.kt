package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils

import android.content.Context
import android.net.Uri

enum class FileType(val suffix: String) {
    IMAGE("image/"),
    VIDEO("video/"),
    AUDIO("audio/")
}

object FileUtil {

    fun getFileTypeFromUri(
        context: Context,
        uri: Uri
    ): FileType? {

        val mimeType = context.contentResolver.getType(uri) ?: return null

        return when {
            mimeType.startsWith(FileType.IMAGE.suffix) -> FileType.IMAGE
            mimeType.startsWith(FileType.VIDEO.suffix) -> FileType.VIDEO
            mimeType.startsWith(FileType.AUDIO.suffix) -> FileType.AUDIO
            else -> null
        }
    }
}