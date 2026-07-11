package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.location

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
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
import androidx.core.content.ContextCompat
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.LocationServices
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme
import androidx.core.net.toUri

/**
 * Get GPS Location from hardware
 * - Get latitude and longitude from fused location android
 * - Declare permission in manifest
 * - Request permission
 * - If the permission is granted, get the location
 * - If the permission is not granted, request the permission
 * - If the permission is denied, show the dialog
 * - Click button to open google map
 */

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalPermissionsApi::class
)
@Composable
fun ScreenLocation(
    onBack: () -> Unit
) {
    val context = LocalContext.current

    val permissionState = rememberPermissionState(
        permission = android.Manifest.permission.ACCESS_FINE_LOCATION
    )

    var latitude by remember { mutableDoubleStateOf(0.0) }
    var longitude by remember { mutableDoubleStateOf(0.0) }
    var showDeniedDialog by remember { mutableStateOf(false) }

    val fusedLocationClient = remember {
        LocationServices.getFusedLocationProviderClient(context)
    }

    fun getLocation() {
        if (ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Call get location from hardware
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location ->
                    if (location != null) {
                        latitude = location.latitude
                        longitude = location.longitude
                        println("Latitude: $latitude")
                        println("Longitude: $longitude")
                    } else {
                        Toast.makeText(
                            context,
                            "Location not found. Please turn on GPS.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        } else {
            // Request the permission
            permissionState.launchPermissionRequest()
        }
    }

    fun openGoogleMap() {
        val geoUri = "geo:$latitude,$longitude?q=$latitude,$longitude".toUri()

        val mapIntent = Intent(
            Intent.ACTION_VIEW,
            geoUri
        ).apply {
            setPackage("com.google.android.apps.maps")
        }

        try {
            context.startActivity(mapIntent)
        } catch (_: ActivityNotFoundException) {
            // Google Maps app is not installed.
            // Open the location using any available map application.
            val fallbackIntent = Intent(
                Intent.ACTION_VIEW,
                geoUri
            )
            context.startActivity(fallbackIntent)
        }
    }


    LaunchedEffect(permissionState.status) {
        if (permissionState.status.isGranted) {
            getLocation()
        } else if (ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_DENIED
        ) {
            showDeniedDialog = true
        }
    }


    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBack()
                        },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Text(text = "Location")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp)
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        // Check if the permission is granted
                        getLocation()
                    }
                ) {
                    Text("Get Location")
                }
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        openGoogleMap()
                    }
                ) {
                    Text("Open Google Map")
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Latitude: $latitude")
            Text(text = "Longitude: $longitude")
        }

        if (showDeniedDialog) {
            AlertDialogPermissionDenied(
                title = "Permission Denied",
                message = "Please grant location permission to use this feature.",
                onDismiss = {
                    showDeniedDialog = false
                }
            )
        }
    }
}

@Composable
fun AlertDialogPermissionDenied(
    title: String,
    message: String,
    onDismiss: () -> Unit
) {
    AlertDialog(
        shape = RoundedCornerShape(8.dp),
        containerColor = MaterialTheme.colorScheme.background,
        icon = {
            Icon(
                painter = painterResource(R.drawable.ic_info),
                contentDescription = "Info Icon",
                modifier = Modifier.size(64.dp)
            )
        },
        title = {
            Text(text = title)
        },
        text = {
            Text(text = message)
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text("Close")
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun ScreenLocationPreview() {
    BaseTheme {
        ScreenLocation(onBack = {})
    }
}
