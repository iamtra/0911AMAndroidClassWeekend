package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.screenInfomation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.extension.getScreenInfo

@Composable
fun ScreenDeviceScreenInformation(
    onBack: () -> Unit = {}
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val screenInfo = remember {
        context.getScreenInfo()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Device Screen Information")
                },
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
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            Item(
                label = "Width (Pixels)",
                value = "${screenInfo.widthPx} px"
            )

            Item(
                label = "Height (Pixels)",
                value = "${screenInfo.heightPx} px"
            )

            Item(
                label = "Width (DP)",
                value = "${screenInfo.widthDp} dp"
            )

            Item(
                label = "Height (DP)",
                value = "${screenInfo.heightDp} dp"
            )

            Item(
                label = "Screen Density",
                value = "%.2fx".format(screenInfo.density)
            )

            Item(
                label = "Resolution",
                value = screenInfo.resolution
            )

            Item(
                label = "Aspect Ratio",
                value = screenInfo.aspectRatio
            )

            Item(
                label = "Screen Size",
                value = "%.2f inches".format(screenInfo.physicalSizeInches)
            )

            Item(
                label = "Brightness",
                value = "${screenInfo.brightness}"
            )

            Item(
                label = "Auto Brightness",
                value = if (screenInfo.isAutoBrightness) "Enabled" else "Disabled"
            )

            Item(
                label = "Minimum Brightness",
                value = "${screenInfo.minBrightness}"
            )

            Item(
                label = "Maximum Brightness",
                value = "${screenInfo.maxBrightness}"
            )
        }
    }
}

@Composable
fun Item(label: String, value: String) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label)
        Text(
            text = value,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview(name = "Phone", device = Devices.PIXEL_7, showSystemUi = true)
@Preview(name = "Phone", device = Devices.PIXEL_6, showSystemUi = true)
@Preview(name = "Fold", device = Devices.FOLDABLE, showSystemUi = true)
@Preview(name = "Desktop", device = Devices.DESKTOP, showSystemUi = true)
@Preview(name = "Desktop", device = Devices.TABLET, showSystemUi = true)
@Composable
fun ScreenDeviceScreenInformationPreview() {
    BaseTheme {
        ScreenDeviceScreenInformation()
    }
}