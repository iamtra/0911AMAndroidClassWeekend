package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.userapi

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.request.CreateUserRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.request.UserUpdateRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserModelResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.utils.LoadingUtil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenUserApi(
    userApiVM: UserApiVM = viewModel(),
    onBack: () -> Unit = {}
) {
    val context = LocalContext.current
    val userUiState by userApiVM.userListUiState.collectAsStateWithLifecycle()
    val userCreateUiState by userApiVM.createUserUiState.collectAsStateWithLifecycle()
    val userDeleteUiState by userApiVM.userDeleteUiState.collectAsStateWithLifecycle()
    val userUpdateUiState by userApiVM.updateUserUiState.collectAsStateWithLifecycle()


    var fullName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var userId by remember { mutableStateOf("") }
    var isDelete by remember { mutableStateOf(false) }
    var isEdit by remember { mutableStateOf(false) }
    var isShowCreateUserSheet by remember { mutableStateOf(false) }
    val emailPattern = remember {
        Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    }

    val isFullNameValid = fullName.trim().isNotEmpty()
    val isEmailValid = email.matches(emailPattern)

    fun onConfirm() {
        val body = CreateUserRequest(
            name = fullName,
            email = email
        )
        userApiVM.createUser(
            body = body
        )
    }

    fun onEdit() {
        val body = UserUpdateRequest(
            name = fullName,
            email = email
        )
        userApiVM.updateUser(
            id = userId,
            body = body
        )
    }

    LaunchedEffect(Unit) {
        userApiVM.getUser()
    }

    LaunchedEffect(key1 = userUiState) {
        when (val state = userUiState) {
            is BaseUiState.Loading -> {
                LoadingUtil.showLoading()
            }

            is BaseUiState.Success -> {
                LoadingUtil.hideLoading()
            }

            is BaseUiState.Error -> {
                LoadingUtil.hideLoading()
            }

            else -> {

            }
        }
    }

    LaunchedEffect(userCreateUiState) {
        when (val state = userCreateUiState) {
            is BaseUiState.Loading -> {
                LoadingUtil.showLoading()
            }

            is BaseUiState.Success -> {
                val toast = Toast.makeText(context, state.data.message, Toast.LENGTH_SHORT)
                toast.show()
                isShowCreateUserSheet = false
                userApiVM.getUser()
                LoadingUtil.hideLoading()
            }

            is BaseUiState.Error -> {
                LoadingUtil.hideLoading()
            }

            else -> {

            }
        }
    }

    LaunchedEffect(userDeleteUiState) {
        when (val state = userDeleteUiState) {
            is BaseUiState.Loading -> {
                LoadingUtil.showLoading()
            }

            is BaseUiState.Success -> {
                val toast = Toast.makeText(context, state.data.message, Toast.LENGTH_SHORT)
                toast.show()
                isShowCreateUserSheet = false
                userApiVM.getUser()
                LoadingUtil.hideLoading()
            }

            is BaseUiState.Error -> {
                LoadingUtil.hideLoading()
            }

            else -> {

            }
        }
    }

    LaunchedEffect(userUpdateUiState) {
        when (val state = userUpdateUiState) {
            is BaseUiState.Loading -> {
                LoadingUtil.showLoading()
            }

            is BaseUiState.Success -> {
                val toast = Toast.makeText(context, state.data.message, Toast.LENGTH_SHORT)
                toast.show()
                isShowCreateUserSheet = false
                userApiVM.getUser()
                LoadingUtil.hideLoading()
            }

            is BaseUiState.Error -> {
                LoadingUtil.hideLoading()
            }

            else -> {

            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            userApiVM.onDispose()
        }
    }

    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "User Api",
                        fontSize = 16.sp,
                    )
                },
                actions = {

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    actionIconContentColor = Color.Blue,
                    titleContentColor = Color.DarkGray
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isShowCreateUserSheet = true
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "Back"
                )
            }
        }
    ) {
        when (val state = userUiState) {
            is BaseUiState.Success -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                        .padding(top = 12.dp)
                        .verticalScroll(
                            state = rememberScrollState(),
                        ),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    state.data.data.forEach { user ->
                        user.let {
                            UserApiItem(
                                user = user,
                                onClickDelete = { id ->
                                    userId = id
                                    isDelete = true
                                },
                                onClickItem = {
                                    isShowCreateUserSheet = true
                                    userId = user.id
                                    fullName = user.name
                                    email = user.email
                                    isEdit = true
                                }
                            )
                            HorizontalDivider()
                        }
                    }
                }
            }

            else -> {}
        }

        if (isDelete) {
            AlertDialog(
                shape = RoundedCornerShape(0.dp),
                containerColor = colorResource(R.color.purple_200),
                icon = {
                    Icon(Icons.Filled.Info, contentDescription = "Info Icon")
                },
                title = {
                    Text(text = "Delete Users")
                },
                text = {
                    Text(text = "Are you sure do really one to delete this user?")
                },
                onDismissRequest = {
                    isDelete = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            isDelete = false
                            userApiVM.deleteUser(userId)
                        }
                    ) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { isDelete = false }) {
                        Text("No")
                    }
                }
            )
        }

        if (isShowCreateUserSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    isShowCreateUserSheet = false
                    isEdit = false
                    userId = ""
                    fullName = ""
                    email = ""
                },
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Create new user",
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 18.sp,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = fullName,
                        onValueChange = { input ->
                            // Allow only letters and spaces
                            fullName = input.filter {
                                it.isLetter() || it.isWhitespace()
                            }
                        },
                        singleLine = true,
                        label = {
                            Text("Full Name")
                        },
                        placeholder = {
                            Text("Enter full name")
                        },
                        isError = !isFullNameValid && fullName.isNotEmpty(),
                        supportingText = {
                            if (!isFullNameValid && fullName.isNotEmpty()) {
                                Text("Full name is required")
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Words,
                            keyboardType = KeyboardType.Text
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Email
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = email,
                        onValueChange = { input ->
                            // Restrict spaces in email
                            email = input.replace(" ", "")
                        },
                        singleLine = true,
                        label = {
                            Text("Email")
                        },
                        placeholder = {
                            Text("Enter email address")
                        },
                        isError = !isEmailValid && email.isNotEmpty(),
                        supportingText = {
                            if (!isEmailValid && email.isNotEmpty()) {
                                Text("Invalid email address")
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Done
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    FilledTonalButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        onClick = {
                            if (isEdit) {
                                onEdit()
                            } else {
                                onConfirm()
                            }
                        },
                        enabled = isFullNameValid && isEmailValid,
                        colors = ButtonDefaults.buttonColors(
                            disabledContainerColor = Color.Gray,
                            disabledContentColor = Color.White
                        )
                    ) {
                        Text(
                            text = if (isEdit) "Update" else "Create",
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun UserApiItem(
    user: UserModelResponse,
    onClickDelete: (id: String) -> Unit,
    onClickItem: () -> Unit
) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .clickable {
                onClickItem()
            }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(48.dp)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = user.name.first().toString(),
                color = MaterialTheme.colorScheme.background
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = user.name,
                color = Color.DarkGray
            )
            Text(
                text = user.email,
                color = Color.DarkGray
            )
        }
        IconButton(
            onClick = {
                onClickDelete(user.id)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = "Delete",
                tint = MaterialTheme.colorScheme.error
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenUserApiPreview() {
    BaseTheme {
        ScreenUserApi()
    }
}


/**
 * 1. Click plus button, Show bottom sheet to insert user
 * 2. Click confirm, send data to api
 * 3. During submitting, we need to show loading state
 * 4. If success, show success dialog  (User create successfully)
 *      - Rerender user list
 * 5. If error, show error dialog (Something went wrong)
 * 6. If canceled, hide bottom sheet
 */

/**
 * 1. Ui Jetpack Compose (Layout + Component)
 * 2. MVVM
 * 3. Model (Business Logic)
 * 4. View (Ui)
 * 5. ViewModel (state)
 * 6. Repository (data)
 * 7. UseCase (logic)
 * 8. Retrofit (API) + Ktor (API)
 * 9. Coroutine (Thread)
 * 10. Unit Test
 * 11. Demo
 */











