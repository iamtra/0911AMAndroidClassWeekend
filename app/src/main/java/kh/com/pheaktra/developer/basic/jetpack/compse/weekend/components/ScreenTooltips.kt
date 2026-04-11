package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.RichTooltipColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenToolsTips() {
    val tooltipsState = rememberTooltipState()
    val coroutineScope = rememberCoroutineScope()
    val message = "This is a message."

    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "ToolTips",
                        fontSize = 16.sp,
                    )
                },
                actions = {

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.purple_200),
                    actionIconContentColor = Color.Blue,
                    titleContentColor = Color.DarkGray
                )
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(top = 12.dp)
                .verticalScroll(
                    state = rememberScrollState(),
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            TooltipBox(
                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
                state = tooltipsState,
                modifier = Modifier.fillMaxSize(),
                focusable = false,
                enableUserInput = true,
                tooltip = {
                    RichTooltip(
                        title = {
                            Text("Additional Information.")
                        },
                        tonalElevation = 16.dp,
//                        caretSize = DpSize(width = 56.dp, height = 120.dp),
                        colors = RichTooltipColors(
                            containerColor = colorResource(R.color.purple_200),
                            titleContentColor = colorResource(R.color.black),
                            contentColor = colorResource(R.color.black),
                            actionContentColor = colorResource(R.color.red)
                        ),
                        shape = RoundedCornerShape(
                            topEnd = 8.dp,
                            bottomEnd = 8.dp,
                            topStart = 8.dp,
                            bottomStart = 8.dp
                        ),
                        shadowElevation = 16.dp,
                        action = {
                            TextButton(
                                onClick = {
                                    coroutineScope.launch {
                                        tooltipsState.dismiss()
                                    }
                                }
                            ) {
                                Text("Close")
                            }
                        }
                    ) {
                        OutlinedTextField(
                            value = "",
                            onValueChange = {

                            },
                            modifier = Modifier.fillMaxWidth(),
                            enabled = true
                        )
                    }
                },
            ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Click here to see additional info.",
                            fontSize = 16.sp,
                        )
                        IconButton(
                            onClick = {
                                coroutineScope.launch {
                                    tooltipsState.show()
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_info),
                                contentDescription = ""
                            )
                        }
                    }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenToolsTipsPreview() {
    ScreenToolsTips()
}