package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home.HomeScreen
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.account.ScreenAccount
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.NavigationItemModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldLayout() {
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
        topBar = {
            TopAppBar(
                navigationIcon = {
                },
                title = {
                    Text(
                        text = "Hello Mama",
                        style = MaterialTheme.typography.headlineLarge
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            println("You clicked action share")
                        },
                        modifier = Modifier
                            .size(height = 48.dp, width = 64.dp)
                            .padding(end = 16.dp)
                            .border(
                                width = 1.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(16.dp)
                            ),
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_notifications_none),
                            contentDescription = "Share",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                )
            )
        },
        bottomBar = {
            androidx.compose.material3.NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp
            ) {
                list.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedIndex,
                        onClick = { selectedIndex = index },
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.label
                            )
                        },
                        label = { Text(text = item.label) }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Handle FAB click */ },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_add),
                    contentDescription = "Add"
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Hello 1")
            Text("Hello 1")
            Text("Hello 1")
            Text("Hello 1")
            Text("Hello 1")
            Text("Hello 1")
            Text("Hello 1")
            Text("Hello 1")
            Text("Hello 1")
            Text("Hello 1")
            Text("Hello 1")
        }
    }
}


/**
 * - Component
 * - Layout
 * - Theme
 * - Activity lifecycle
 */

@Preview(showBackground = true)
@Composable
fun ScaffoldLayoutPreview() {
    BaseTheme {
        ScaffoldLayout()
    }
}