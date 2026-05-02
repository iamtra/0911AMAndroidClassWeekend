package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R


/**
 * Please practice detail
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTextFiled() {
    var value by remember { mutableStateOf("") }
    var value1 by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
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
                        text = "Text Field",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W900,
                        color = MaterialTheme.colorScheme.surface
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
            ) {

                OutlinedTextField(
                    modifier = Modifier.height(48.dp),
                    value = value,
                    onValueChange = {
                        value = it
                        println("======> $it")
                    },
                    enabled = true,
                    textStyle = TextStyle.Default,
                    label = {
                        Text(
                            text = "Enter your name."
                        )
                    },
                    placeholder = {
                        Text("Please enter your name.")
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_profile),
                            contentDescription = "Icon user"
                        )
                    },
                    trailingIcon = {
                        if (value.isNotEmpty()) {
                            IconButton(
                                onClick = {
                                    value = ""
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Icon user"
                                )
                            }
                        }
                    }
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            BasicTextField(
                value = value,
                onValueChange = { value = it },
                singleLine = true,
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(R.color.milk), RoundedCornerShape(8.dp))
                            .padding(12.dp)
                    ) {
                        if (value.isEmpty()) {
                            Text("Enter text here...", color = Color.Gray)
                        }
                        innerTextField()
                    }
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenTextFiledPreview() {
    ScreenTextFiled()
}
