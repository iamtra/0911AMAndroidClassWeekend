package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.bottom_navigation_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.NavigationItemModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenBottomNavigationBar() {

    var selectedIndex by remember { mutableIntStateOf(0) }
    val list = listOf<NavigationItemModel>(
        NavigationItemModel(
            label = "Home",
            icon = R.drawable.ic_home,
        ),
        NavigationItemModel(
            label = "Video",
            icon = R.drawable.ic_video,
        ),
        NavigationItemModel(
            label = "Profile",
            icon = R.drawable.ic_profile,
        ),
    )
    Scaffold(
//        modifier = Modifier.navigationBarsPadding(),
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
                        text = "Screen Bottom NavigationBar",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.W900,
                    )
                },
                actions = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Menu Icon"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.purple_200),
                    actionIconContentColor = Color.Blue,
                    titleContentColor = Color.DarkGray
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                windowInsets = BottomAppBarDefaults.windowInsets,
                containerColor = colorResource(R.color.purple_200),
            ) {
                list.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedIndex,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = "Menu Icon"
                            )
                        },
                        label = {
                            Text(
                                text = item.label,
                                fontSize = 24.sp
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = colorResource(R.color.teal_200),
                            selectedTextColor = colorResource(R.color.red),
                            indicatorColor = colorResource(R.color.red)
                        )
                    )
                }
            }
        }
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
            when(selectedIndex) {
                0 -> Text("Home")
                1-> Text("Video")
                2 -> Text("Profile")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenBottomNavigationBarPreview() {
    ScreenBottomNavigationBar()
}