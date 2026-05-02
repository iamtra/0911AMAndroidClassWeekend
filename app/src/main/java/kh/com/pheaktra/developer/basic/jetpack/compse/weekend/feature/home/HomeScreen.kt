package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.DashboardModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.NavigationItemModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.OtherServiceItemModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.TransactionModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.local.transactionList

/**
 * 1. Computer
 * 2. Smartphone
 * 3. Accessory
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    var selectedIndex by remember { mutableIntStateOf(0) }
    val transactions = transactionList

    val list = listOf(
        NavigationItemModel(
            label = "Home",
            icon = R.drawable.ic_home,
        ),
        NavigationItemModel(
            label = "Video",
            icon = R.drawable.ic_qr_code_scanner,
        ),
        NavigationItemModel(
            label = "Profile",
            icon = R.drawable.ic_profile,
        ),
    )
    Scaffold(
        topBar = {
            HomeScreenTopBar()
        },
        bottomBar = {
            BottomAppBar(
                windowInsets = BottomAppBarDefaults.windowInsets,
                containerColor = colorResource(R.color.white),
            ) {
                list.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedIndex,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            if (index == 1) {
                                IconButton(
                                    modifier = Modifier.size(64.dp),
                                    onClick = {

                                    },
                                    colors = IconButtonDefaults.filledIconButtonColors(
                                        containerColor = colorResource(R.color.dark_blue)
                                    )
                                ) {
                                    Icon(
                                        modifier = Modifier.size(48.dp),
                                        painter = painterResource(id = item.icon),
                                        contentDescription = "Menu Icon",
                                        tint = colorResource(R.color.white)
                                    )
                                }
                            } else {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = "Menu Icon"
                                )
                            }
                        },
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer
                )
                .verticalScroll(
                    state = scrollState,
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            MainCardDashboard()
            OtherServices()
            Spacer(Modifier.height(16.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                text = "Transaction",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(16.dp))

            /**
             * Transaction List
             */
            TransactionList(transactions)
            /**
             * Other Service
             */
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar() {
    TopAppBar(
        navigationIcon = {
            IconButton(
                modifier = Modifier
                    .size(48.dp)
                    .padding(start = 16.dp)
                    .background(
                        color = colorResource(R.color.blue_900),
                        shape = CircleShape
                    ),
                onClick = {

                }
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Icon wallet",
                    tint = colorResource(R.color.white)
                )
            }
        },
        title = {
            Column(
                modifier = Modifier.padding(start = 16.dp),
//                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Hello Mama",
                    fontSize = 12.sp
                )
                Text(
                    text = "Welcome Back!",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.dark_blue)
                )
            }
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
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        )
    )
}


@Composable
fun TransactionList(list: List<TransactionModel>) {
    for (transaction in list) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .padding(horizontal = 16.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    modifier = Modifier
                        .size(56.dp)
                        .background(
                            color = colorResource(R.color.blue_900),
                            shape = CircleShape
                        ),
                    onClick = {

                    }
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "Icon wallet",
                        tint = colorResource(R.color.white)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row() {
                        Text(transaction.senderName)
                        Spacer(modifier = Modifier.weight(1f))
                        Text("${transaction.currency} ${transaction.transactionAmount + transaction.feeAmount}")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row() {
                        Text(transaction.senderName)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(transaction.transactionDate)
                    }
                }
            }
        }
        Spacer(Modifier.height(8.dp))
    }
}


@Composable
fun MainCardDashboard() {
    val items = arrayListOf(
        DashboardModel(
            id = "001",
            label = "Balance",
            iconRes = R.drawable.ic_dollars
        ),
        DashboardModel(
            id = "002",
            label = "Add Money",
            iconRes = R.drawable.ic_wallets
        ),
        DashboardModel(
            id = "003",
            label = "Send",
            iconRes = R.drawable.ic_send
        ),
        DashboardModel(
            id = "004",
            label = "Received",
            iconRes = R.drawable.ic_received
        ),
        DashboardModel(
            id = "005",
            label = "History",
            iconRes = R.drawable.ic_histroy
        ),
    )
    Box(
        modifier = Modifier
            .height(230.dp)
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = colorResource(R.color.dark_blue),
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_wallets),
                            contentDescription = "Icon wallet",
                            tint = colorResource(R.color.white)
                        )
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = "Your wallet balance",
                            fontSize = 16.sp,
                            color = colorResource(R.color.white)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_dollars),
                            contentDescription = "Balance",
                            tint = colorResource(R.color.white)
                        )
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = "24,562.00",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            overflow = TextOverflow.Ellipsis,
                            color = colorResource(R.color.white)
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(R.drawable.ic_qr_code_scanner),
                    contentDescription = "Icon QR Code",
                    tint = colorResource(R.color.white)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                for (i in items) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            modifier = Modifier
                                .size(56.dp)
                                .background(
                                    color = colorResource(R.color.blue_900),
                                    shape = CircleShape
                                ),
                            onClick = {

                            }
                        ) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(id = i.iconRes),
                                contentDescription = "Icon wallet",
                                tint = colorResource(R.color.white)
                            )
                        }
                        Text(
                            modifier = Modifier.padding(top = 8.dp),
                            text = i.label,
                            color = colorResource(R.color.white)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun OtherServices() {
    val items = arrayListOf(
        OtherServiceItemModel(
            id = "001",
            label = "Recharge",
            iconRes = R.drawable.ic_dollars,
            iconColorRes = R.color.icon_recharge,
            backgroundColorRes = R.color.bg_recharge
        ),
        OtherServiceItemModel(
            id = "002",
            label = "Bill Pay",
            iconRes = R.drawable.ic_wallets,
            iconColorRes = R.color.icon_bill_pay,
            backgroundColorRes = R.color.bg_bill_pay
        ),
        OtherServiceItemModel(
            id = "003",
            label = "Bank Transfer",
            iconRes = R.drawable.ic_send,
            iconColorRes = R.color.icon_bank_transfer,
            backgroundColorRes = R.color.bg_bank_transfer
        ),
        OtherServiceItemModel(
            id = "004",
            label = "Saving",
            iconRes = R.drawable.ic_received,
            iconColorRes = R.color.icon_savings,
            backgroundColorRes = R.color.bg_savings
        ),
        OtherServiceItemModel(
            id = "005",
            label = "Electricity",
            iconRes = R.drawable.ic_histroy,
            iconColorRes = R.color.icon_electricity,
            backgroundColorRes = R.color.bg_electricity
        ),
        OtherServiceItemModel(
            id = "003",
            label = "Movie",
            iconRes = R.drawable.ic_send,
            iconColorRes = R.color.icon_movie,
            backgroundColorRes = R.color.bg_movie
        ),
        OtherServiceItemModel(
            id = "004",
            label = "Add Money",
            iconRes = R.drawable.ic_received,
            iconColorRes = R.color.icon_add_money,
            backgroundColorRes = R.color.bg_add_money
        ),
        OtherServiceItemModel(
            id = "005",
            label = "Others",
            iconRes = R.drawable.ic_histroy,
            iconColorRes = R.color.icon_others,
            backgroundColorRes = R.color.bg_others
        ),
    )
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(240.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Other Services",
                fontSize = 24.sp
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                contentPadding = PaddingValues(16.dp),
                userScrollEnabled = false,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)

            ) {
                items(items) { i ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            modifier = Modifier
                                .size(48.dp)
                                .background(
                                    color = colorResource(i.backgroundColorRes),
                                    shape = RoundedCornerShape(16.dp)
                                ),
                            onClick = {

                            }
                        ) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(id = i.iconRes),
                                contentDescription = "Icon wallet",
                                tint = colorResource(i.iconColorRes)
                            )
                        }
                        Text(
                            modifier = Modifier.padding(top = 8.dp),
                            text = i.label,
                            color = colorResource(R.color.black),
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}
