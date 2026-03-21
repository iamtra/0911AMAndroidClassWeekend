package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kotlin.collections.mutableListOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCheckBox() {
    data class OptionModel(
        val label: String,
        var isSelect: Boolean,
    )
    var isSelected by remember { mutableStateOf(false) }
    val options = remember { mutableStateListOf<OptionModel>(
        OptionModel(label = "Option 1", isSelect = false),
        OptionModel(label = "Option 2", isSelect = true),
        OptionModel(label = "Option 3", isSelect = false),
        OptionModel(label = "Option 4", isSelect = false),
        OptionModel(label = "Option 5", isSelect = false),
        OptionModel(label = "Option 6", isSelect = false),
        OptionModel(label = "Option 7", isSelect = false),
    )}
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            println("You click Navigation Icon")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu Icon"
                        )
                    }
                },
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Check Box",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W900,
                        fontStyle = FontStyle.Italic
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            println("You clicked action share")
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notification),
                            contentDescription = "share Icon",
                            tint = Color.Unspecified
                        )
                    }
                    BadgedBox(
                        badge = {
                            Badge()
                        }
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notification),
                            contentDescription = "Notification Icon",
                        )
                    }
                    IconButton(
                        onClick = {
                            println("You clicked action setting")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings Icon"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.purple_200),
                    actionIconContentColor = Color.Blue,
                    titleContentColor = Color.DarkGray
                )
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(top = 12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            options.forEachIndexed { index, item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        modifier = Modifier,
                        checked = item.isSelect,
                        onCheckedChange = { checked ->
                            println(item)
                            options[index] = item.copy(isSelect = checked)
                        },
                        enabled = true,
//                    colors = MaterialTheme.colorScheme.primaryContainer,
//                    interactionSource = TODO(),
                    )

                    Text(
                        text = "Option 1"
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenCheckBoxPreview() {
    ScreenCheckBox()
}