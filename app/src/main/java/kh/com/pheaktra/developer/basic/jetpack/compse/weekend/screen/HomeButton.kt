package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kotlinx.coroutines.delay

/**
 * 1. Computer
 * 2. Smartphone
 * 3. Accessory
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeButton() {
    var countDown by remember { mutableIntStateOf(10) }

    var selectedIndex by remember { mutableIntStateOf(0) }
    val list = listOf("Computer", "Smartphone", "Accessory")

    LaunchedEffect(Unit) {
        while (countDown >= 0) {
            delay(1000)
            countDown--
        }
    }

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
                        text = "Jetpack",
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                modifier = Modifier
                    .size(64.dp)
                    .background(
                        color = colorResource(R.color.purple_200),
                        shape = RoundedCornerShape(12.dp)
                    ),
                onClick = {
                    println("Enabled Icon butoon")
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = "Click this icon go to search screen."
                )
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(12.dp))
            IconButton(
                enabled = false,
                modifier = Modifier
                    .size(64.dp)
                    .background(
                        color = colorResource(R.color.purple_200),
                        shape = RoundedCornerShape(12.dp)
                    ),
                onClick = {
                    println("Disabled Icon button.")
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = "Click this icon go to search screen."
                )
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(12.dp))
            /**
             * Button Filled Button
             */
            Button(
                modifier = Modifier
                    .background(
                        color = colorResource(R.color.teal_200),
                        shape = CircleShape
                    )
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                onClick = {

                }
            ) {
                Text(
                    text = "$countDown",
//                    fontStyle = FontStyle.Italic,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(
                        Font(R.font.hanuman_extrabold, FontWeight.Normal),
                    )
                )
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(12.dp))
            Button(
                modifier = Modifier
                    .background(
                        color = colorResource(R.color.teal_200),
                        shape = CircleShape
                    )
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                onClick = {
                    println("Filled button has been clicked")
                }
            ) {
                Text(
                    text = stringResource(R.string.lbl_content),
                    fontSize = 24.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(12.dp))


            SingleChoiceSegmentedButtonRow(
                modifier = Modifier.fillMaxWidth(),
                space = SegmentedButtonDefaults.BorderWidth,
            ) {
                list.forEachIndexed { index, label ->
                    val isSelect = selectedIndex == index
                    SegmentedButton(
                        selected = isSelect,
                        onClick = {
                            selectedIndex = index
                        },
                        shape = RoundedCornerShape(0.dp),
                        modifier = Modifier,
                        enabled = true,
                        colors = SegmentedButtonDefaults.colors(
                            activeBorderColor = MaterialTheme.colorScheme.primaryContainer,

                            ),
                        icon = {
                            SegmentedButtonDefaults.Icon(
                                active = isSelect,
                            )
                        },
                        label = {
                            Text(
                                text = label
                            )
                        },
                    )
                }
//                list.forEachIndexed { index, string ->
//
//                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeButtonPreview() {
    HomeButton()
}
