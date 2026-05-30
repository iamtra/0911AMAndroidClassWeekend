package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import okio.IOException
import java.io.File
import java.io.FileOutputStream

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

    fun saveBitmapToCache(
        context: Context,
        bitmap: Bitmap,
        fileName: String = "image_${System.currentTimeMillis()}.png"
    ): File? {
        try {
            val file = File(context.cacheDir, fileName)
            FileOutputStream(file).use { out ->
                bitmap.compress(
                    Bitmap.CompressFormat.PNG, // PNG or JPEG
                    90, // Ignored for PNG
                    out
                )
                out.flush()
            }

            return if (file.exists()) {
                file
            } else {
                null
            }
        } catch (e: IOException) {
            return null
        }
    }

    fun saveBitmapToGallery(
        context: Context,
        bitmap: Bitmap,
        fileName: String = "IMG_${System.currentTimeMillis()}.jpg"
    ): String? {
        val resolver = context.contentResolver

        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")

            put(
                MediaStore.Images.Media.RELATIVE_PATH,
                "Pictures/MyApp"
            )
        }

        val imageUri = resolver.insert(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            contentValues
        )

        imageUri?.let { uri ->
            resolver.openOutputStream(uri)?.use { outputStream ->
                bitmap.compress(
                    Bitmap.CompressFormat.JPEG,
                    90,
                    outputStream
                )
            }
            return uri.toString()
        }

        return null
    }

    fun saveBitmapToDownloads(
        context: Context,
        bitmap: Bitmap,
        fileName: String = "image_download_${System.currentTimeMillis()}.jpg"
    ): String? {

        val appName = context.packageManager
            .getApplicationLabel(context.applicationInfo)
            .toString()

        val values = ContentValues().apply {
            put(MediaStore.Downloads.DISPLAY_NAME, fileName)
            put(MediaStore.Downloads.MIME_TYPE, "image/jpeg")

            put(
                MediaStore.Downloads.RELATIVE_PATH,
                "Download/${appName}"
            )
        }

        val uri = context.contentResolver.insert(
            MediaStore.Downloads.EXTERNAL_CONTENT_URI,
            values
        )

        uri?.let {
            context.contentResolver.openOutputStream(it)?.use { stream ->
                bitmap.compress(
                    Bitmap.CompressFormat.JPEG,
                    90,
                    stream
                )
            }
            return it.toString()
        }

        return null
    }

}