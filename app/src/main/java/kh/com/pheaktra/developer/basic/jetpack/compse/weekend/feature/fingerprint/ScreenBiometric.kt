package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.fingerprint

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.hardware.BiometricStatus
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.hardware.BiometricUtil

@Composable
fun ScreenBiometric(
    onBack: () -> Unit = {}
) {
    val context = LocalContext.current
    var isShow by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text("Fingerprint")
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
        },
        bottomBar = {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val status = BiometricUtil.checkAvailability(context)

                    when(status) {
                        is BiometricStatus.Available -> {
                            result = "Available"
                            BiometricUtil.authenticate(
                                activity = context as FragmentActivity,
                                onSuccess = {
                                    val toast =
                                        Toast.makeText(context, "Success", Toast.LENGTH_SHORT)
                                    toast.show()
                                },
                                onError = { errorCode, errorMessage ->
                                    result = """
                                        Error code: $errorCode
                                        Error message: $errorMessage
                                    """.trimIndent()
                                },
                                onFailed = {
                                    println("=====> onFailed")
                                },
                            )
                        }
                        is BiometricStatus.HardwareUnavailable -> {
                            result = "HardwareUnavailable"
                        }
                        is BiometricStatus.NoHardware -> {
                            result = "NoHardware"
                        }
                        is BiometricStatus.NoneEnrolled -> {
                            result = "NoneEnrolled"
                            isShow = true
                        }
                        is BiometricStatus.Unsupported -> {
                            result = "Unsupported"
                        }
                    }
                }
            ) {
                Text("Open fingerprint")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Biometric status")
                Text(result)
            }
        }

        if (isShow) {
            AlertDialog(
                shape = RoundedCornerShape(0.dp),
                containerColor = colorResource(R.color.purple_200),
                icon = {
                    Icon(painter = painterResource(R.drawable.ic_notifications_none), contentDescription = "Info Icon")
                },
                title = {
                    Text(text = "Biometric is not enrolled")
                },
                text = {
                    Text(text = "Please click confirm to enroll Biometric in your setting.")
                },
                onDismissRequest = {
                    isShow = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            isShow = false
                            BiometricUtil.openBiometricEnrollment(context)
                        }
                    ) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { isShow = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun ScreenBiometricPreview() {
    ScreenBiometric()
}