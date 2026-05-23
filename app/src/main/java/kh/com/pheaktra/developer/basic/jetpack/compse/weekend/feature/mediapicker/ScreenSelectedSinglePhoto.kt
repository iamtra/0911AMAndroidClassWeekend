package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.mediapicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenSelectedSinglePhoto(
    onBack: () -> Unit = {}
) {

    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val pickMedia = rememberLauncherForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        if (uri != null) {
            imageUri = uri
        }
    }

    fun onPickMedia() {
        pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    Scaffold(
        modifier = Modifier.systemBarsPadding(),
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
                    Text("Select Single Photo")
                },
            )
        },
        bottomBar = {
            FilledTonalButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(48.dp),
                onClick = {
                    onPickMedia()
                }
            ) {
                Text("Select Single Photo")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(16.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(18.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    model = imageUri,
                    contentDescription = "Image Uri"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenSelectedSinglePhotoPreview() {
    BaseTheme {
        ScreenSelectedSinglePhoto()
    }
}