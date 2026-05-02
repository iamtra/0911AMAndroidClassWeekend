package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
fun ScreenTabs() {
    var activeIndex by remember { mutableIntStateOf(0) }
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
                        text = "Tabs Component",
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Normal,
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
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
        ) {

            PrimaryTabRow(
                selectedTabIndex = activeIndex,
                divider = {

                }
            ) {
                Tab(
                    selected = activeIndex == 0,
                    onClick = {
                        activeIndex = 0
                    },
                    modifier = Modifier,
                    enabled = true,
                    text = {
                        Text(
                            text = "Home"
                        )
                    },
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.secondary,
                )
                Tab(
                    selected = activeIndex == 1,
                    onClick = {
                        activeIndex = 1
                    },
                    modifier = Modifier,
                    enabled = true,
                    text = {
                        Text(
                            text = "Videos"
                        )
                    },
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.secondary,
                )
                Tab(
                    selected = activeIndex == 2,
                    onClick = {
                        activeIndex = 2
                    },
                    modifier = Modifier,
                    enabled = true,
                    text = {
                        Text(
                            text = "New Feeds"
                        )
                    },
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.secondary,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                when (activeIndex) {
                    0 -> {
                        LazyColumn() {
                            items(100) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp)
                                        .background(
                                            color = MaterialTheme.colorScheme.primaryContainer,
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .clickable(
                                            enabled = true,
                                            onClick = {

                                            }
                                        ),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                                ) {
                                    RadioButton(
                                        selected = false,
                                        onClick = {

                                        }
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Text(
                                        modifier = Modifier.padding(end = 16.dp),
                                        text = "Content Home ${it + 1}"
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }

                    1 -> {
                        LazyColumn() {
                            items(100) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp)
                                        .background(
                                            color = MaterialTheme.colorScheme.primaryContainer,
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .clickable(
                                            enabled = true,
                                            onClick = {

                                            }
                                        ),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                                ) {
                                    RadioButton(
                                        selected = false,
                                        onClick = {

                                        }
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Text(
                                        modifier = Modifier.padding(end = 16.dp),
                                        text = "Content Videos ${it + 1}"
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }

                    2 -> {
                        LazyColumn() {
                            items(100) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp)
                                        .background(
                                            color = MaterialTheme.colorScheme.primaryContainer,
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                        .clickable(
                                            enabled = true,
                                            onClick = {

                                            }
                                        ),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                                ) {
                                    RadioButton(
                                        selected = false,
                                        onClick = {

                                        }
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Text(
                                        modifier = Modifier.padding(end = 16.dp),
                                        text = "New Feed contents ${it + 1}"
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }
                }
            }
        }


    }
}


@Preview(showBackground = true)
@Composable
fun ScreenTabsPreview() {
    ScreenTabs()
}