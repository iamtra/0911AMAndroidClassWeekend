package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.camera

import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.FileUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCameraLauncher(
    onBack: () -> Unit = {}
) {
    val context = LocalContext.current
    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        if (bitmap != null) {
            imageBitmap = bitmap.asImageBitmap()
            val file = FileUtil.saveBitmapToCache(context, bitmap)

//            if (file?.exists() == true) {
//                Toast.makeText(context, "Image save to cache successfully.", Toast.LENGTH_SHORT)
//                    .show()
//            }

            val uri = FileUtil.saveBitmapToDownloads(context, bitmap)
            if (uri != null) {
                Toast.makeText(context, "Image save to download successfully.", Toast.LENGTH_SHORT)
                    .show()
            }
        } else {
            Toast.makeText(context, "Failed to capture image", Toast.LENGTH_SHORT).show()
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            cameraLauncher.launch()
        } else {
            Toast.makeText(context, "Permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    fun openCamera() {
        if (ContextCompat.checkSelfPermission(
                context, android.Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            cameraLauncher.launch()
        } else {
            permissionLauncher.launch(android.Manifest.permission.CAMERA)
        }
    }
    Scaffold(
        modifier = Modifier
            .navigationBarsPadding(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBack()
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_back),
                            contentDescription = null
                        )
                    }
                },
                title = {
                    Text("Camera Launcher")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        bottomBar = {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    openCamera()
                }
            ) {
                Text("Launch Camera")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
            ) {
                imageBitmap?.let { imageBitmap ->
                    Image(
                        bitmap = imageBitmap,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenCameraLauncherPreview() {
    BaseTheme() {
        ScreenCameraLauncher()
    }
}