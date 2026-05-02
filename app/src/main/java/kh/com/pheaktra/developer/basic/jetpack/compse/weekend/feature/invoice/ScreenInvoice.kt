package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.invoice

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenInvoice(
    onBack: () -> Unit = {}
) {
    val context = LocalContext.current
    val invoiceText = remember { mutableStateOf(generateNewInvoice()) }
    LaunchedEffect(Unit) {

    }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Text("Invoice")
                }
            )
        },
        bottomBar = {
            Button(
                onClick = {
                    val bitmap = generateInvoiceBitmap(invoiceText.value)
//                    saveBitmapToDocumentsAndOpen(context, bitmap, "invoice_${System.currentTimeMillis()}.png")
                    saveAndShareInvoice(context, bitmap, "invoice_${System.currentTimeMillis()}.png")
                }
            ) {
                Text("Save Invoice as Image")
            }
}
    ) { padding ->
        Column(
            modifier = Modifier.padding(paddingValues = padding)
        ) {
            Text(
                text = invoiceText.value
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenInvoicePreview() {
    ScreenInvoice()
}

fun generateNewInvoice(): String {
    return """
            ================== INVOICE ==================
            Invoice No   : INV-2026-0001
            Date         : 2026-02-28
            Customer     : Member
            
            ------------------ ITEM --------------------
            Product Name : Phone Charger
            Category     : Accessory
            Unit Price   : 15.00 USD
            Quantity     : 2
            
            ------------------ TOTAL -------------------
            Subtotal     : 30.00 USD
            Tax (10%)    : 3.00 USD
            Grand Total  : 33.00 USD
            
            ------------------ PAYMENT -----------------
            Payment Mode : Cash
            Status       : PAID
            
            ===========================================
            Thank you for your purchase!
        """.trimIndent()
}

fun generateInvoiceBitmap(text: String): Bitmap {
    // Set text properties
    val paint = Paint().apply {
        color = Color.BLACK
        textSize = 32f
        isAntiAlias = true
    }

    val lines = text.lines()
    val width = lines.maxOf { paint.measureText(it).toInt() } + 40
    val height = lines.size * (paint.textSize.toInt() + 10) + 40

    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    canvas.drawColor(android.graphics.Color.WHITE)

    var y = 40f
    for (line in lines) {
        canvas.drawText(line, 20f, y, paint)
        y += paint.textSize + 10
    }

    return bitmap
}


fun saveBitmapToDocumentsAndOpen(context: Context, bitmap: Bitmap, fileName: String, folderName: String = "Invoices") {
    try {
        // Get Documents folder path
        val documentsDir = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), folderName)

        // Create folder if it doesn't exist
        if (!documentsDir.exists()) {
            documentsDir.mkdirs()
        }

        // Create the file
        val file = File(documentsDir, fileName)

        // Save bitmap
        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        }

        Toast.makeText(context, "Invoice saved: ${file.absolutePath}", Toast.LENGTH_LONG).show()
        println("Invoice saved at: ${file.absolutePath}")

        // Open folder using Intent
        val folderUri: Uri = FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            documentsDir
        )

        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(folderUri, "resource/folder")
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK
        }

        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        } else {
            Toast.makeText(context, "Cannot open folder. Use a file manager.", Toast.LENGTH_SHORT).show()
        }

    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(context, "Failed to save invoice", Toast.LENGTH_SHORT).show()
    }
}

fun saveAndShareInvoice(
    context: Context,
    bitmap: Bitmap,
    fileName: String,
    folderName: String = "Invoices"
) {
    try {
        // Create Documents folder
        val documentsDir = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), folderName)
        if (!documentsDir.exists()) documentsDir.mkdirs()

        // Save bitmap
        val file = File(documentsDir, fileName)
        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        }

        // Get URI using FileProvider
        val uri: Uri = FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file
        )

        // Share via social apps
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "image/png"
            putExtra(Intent.EXTRA_STREAM, uri)
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        }

        context.startActivity(
            Intent.createChooser(shareIntent, "Share Invoice via")
        )

        Toast.makeText(context, "Invoice saved and ready to share", Toast.LENGTH_LONG).show()

    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(context, "Failed to save/share invoice", Toast.LENGTH_SHORT).show()
    }
}
