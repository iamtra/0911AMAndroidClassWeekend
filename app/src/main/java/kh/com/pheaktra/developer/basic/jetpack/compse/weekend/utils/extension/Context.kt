package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.extension

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.shareImageUri(
    imageUri: Uri,
    chooserTitle: String = "Share image"
) {
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "image/*"
        putExtra(Intent.EXTRA_STREAM, imageUri)
        putExtra(Intent.EXTRA_TEXT, chooserTitle)
        clipData = ClipData.newUri(
            contentResolver,
            "Shared image",
            imageUri
        )
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }

    startActivity(
        Intent.createChooser(shareIntent, chooserTitle)
    )
}