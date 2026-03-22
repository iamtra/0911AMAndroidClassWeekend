package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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

@Composable
fun ScreenAccount() {
    val accountList = accountList
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopbarAccount(title = "Account", description = "Kotlin Android")
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            items(accountList.size) { index ->
                AccountComponent(accountList[index])
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopbarAccount(title: String, description: String) {
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
                    text = title,
                    fontSize = 12.sp
                )
                Text(
                    text = description,
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
fun AccountComponent(account: BankAccountModel) {
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
            .wrapContentSize()
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
                            painter = painterResource(
                                id = if (account.currency == CurrencyTypeCode.KHR.code) R.drawable.ic_riel else R.drawable.ic_dollars
                            ),
                            contentDescription = "Balance",
                            tint = colorResource(R.color.white)
                        )
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            text = account.balance.toString(),
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
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                for (i in items) {
//                    Column(
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        IconButton(
//                            modifier = Modifier
//                                .size(56.dp)
//                                .background(
//                                    color = colorResource(R.color.blue_900),
//                                    shape = CircleShape
//                                ),
//                            onClick = {
//
//                            }
//                        ) {
//                            Icon(
//                                modifier = Modifier.size(24.dp),
//                                painter = painterResource(id = i.iconRes),
//                                contentDescription = "Icon wallet",
//                                tint = colorResource(R.color.white)
//                            )
//                        }
//                        Text(
//                            modifier = Modifier.padding(top = 8.dp),
//                            text = i.label,
//                            color = colorResource(R.color.white)
//                        )
//                    }
//                }
//            }
        }
    }
}

// JSON -> Convert JSON to data class

@Preview
@Composable
fun ScreenAccountPreview() {
    ScreenAccount()
}

enum class AccountTypeCode(val code: String) {
    SAVING_ACCOUNT("01"),
    DEPOSIT_ACCOUNT("02"),
    JUNIOR_ACCOUNT("03"),
    CURRENT_ACCOUNT("04"),
    LOAN_ACCOUNT("05"),
}

enum class CurrencyTypeCode(val code: String) {
    KHR("KHR"),
    USD("USD")
}

data class BankAccountModel(
    val accountId: String,
    val accountNumber: String,
    val accountHolderName: String,
    val bankName: String,
    val branchName: String? = null,
    val balance: Double,
    val currency: String = "USD",
    val accountType: String, // 01, 02, 03, 04, 05
    val isActive: Boolean = true,
    val createdAt: Long,
    val updatedAt: Long? = null
)

fun String.toAccountType(): String {
    return when (this) {
        AccountTypeCode.SAVING_ACCOUNT.code -> "Saving"
        AccountTypeCode.DEPOSIT_ACCOUNT.code -> "Deposit"
        AccountTypeCode.JUNIOR_ACCOUNT.code -> "Junior"
        AccountTypeCode.CURRENT_ACCOUNT.code -> "Current"
        AccountTypeCode.LOAN_ACCOUNT.code -> "Loan"
        else -> "Unknown"
    }
}

val accountList = mutableListOf(
    BankAccountModel(
        accountId = "01",
        accountHolderName = "machalate",
        accountNumber = "100999888",
        bankName = "ABA Bank",
        branchName = "Phnom Penh",
        balance = 2000000.0,
        currency = "KHR",
        accountType = "01",
        isActive = true,
        createdAt = 202603220948,
        updatedAt = 202603220948,
    ),
    BankAccountModel(
        accountId = "02",
        accountHolderName = "sokha",
        accountNumber = "200888777",
        bankName = "ACLEDA Bank",
        branchName = "Phnom Penh",
        balance = 1500000.0,
        currency = "KHR",
        accountType = "02",
        isActive = true,
        createdAt = 202603220950,
        updatedAt = 202603220950,
    ),
    BankAccountModel(
        accountId = "03",
        accountHolderName = "dara",
        accountNumber = "300777666",
        bankName = "Canadia Bank",
        branchName = "Siem Reap",
        balance = 5000000.0,
        currency = "USD",
        accountType = "01",
        isActive = true,
        createdAt = 202603220955,
        updatedAt = 202603220955,
    ),
    BankAccountModel(
        accountId = "04",
        accountHolderName = "vannak",
        accountNumber = "400666555",
        bankName = "Wing Bank",
        branchName = "Battambang",
        balance = 750000.0,
        currency = "KHR",
        accountType = "03",
        isActive = false,
        createdAt = 202603221000,
        updatedAt = 202603221000,
    ),
    BankAccountModel(
        accountId = "05",
        accountHolderName = "lina",
        accountNumber = "500555444",
        bankName = "ABA Bank",
        branchName = "Phnom Penh",
        balance = 3200.0,
        currency = "USD",
        accountType = "02",
        isActive = true,
        createdAt = 202603221005,
        updatedAt = 202603221005,
    )
)