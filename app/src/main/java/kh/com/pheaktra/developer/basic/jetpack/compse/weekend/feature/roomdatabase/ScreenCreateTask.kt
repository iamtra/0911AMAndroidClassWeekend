package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.roomdatabase

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.android.domain.model.TaskModel
import kh.com.pheaktra.developer.android.util.common.ValueYN
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme
import kh.com.pheaktra.developer.android.util.common.extension.isYes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenCreateTask(
    taskData: TaskModel? = null,
    roomVM: RoomVM = viewModel(),
    onBack: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val density = LocalDensity.current
    val focusRequester = remember { FocusRequester() }

    var taskName by remember {
        mutableStateOf("")
    }

    var taskDescription by remember {
        mutableStateOf("")
    }
    var taskCompletedYN by remember {
        mutableStateOf(ValueYN.NO)
    }

    val isKeyboardVisible = WindowInsets.ime.getBottom(density) > 0

    fun onSave() {
        val task = TaskModel(
            taskId = taskData?.taskId ?: 0L,
            taskName = taskName.trim(),
            taskDescription = taskDescription.trim(),
            taskCompletedYN = taskCompletedYN
        )
        if (taskData != null) {
            roomVM.updateTask(task)
        } else {
            roomVM.createTask(task)
        }
        onBack()
    }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
//        keyboardController?.show()
    }

    LaunchedEffect(key1 = taskData) {
        if (taskData != null) {
            taskName = taskData.taskName
            taskDescription = taskData.taskDescription
            taskCompletedYN = taskData.taskCompletedYN
        }
    }

    Scaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .clickable(
                enabled = true,
                onClick = {
                    keyboardController?.hide()
                },
                indication = null,
                interactionSource = null
            )
            .imePadding(),
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
                        text = "Create Task",
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
        bottomBar = {
            Button(
                onClick = {
                    onSave()
                },
                modifier = Modifier
                    .padding(
                        horizontal = if (!isKeyboardVisible) 16.dp else 0.dp
                    )
                    .clip(
                        RoundedCornerShape(
                            if (!isKeyboardVisible) 16.dp else 0.dp
                        )
                    )
                    .fillMaxWidth()
                    .imePadding(),
                enabled = taskName.isNotBlank()
            ) {
                Text(
                    text = if (taskData == null) {
                        "Create Task"
                    } else {
                        "Update Task"
                    }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                value = taskName,
                onValueChange = { taskName = it },
                label = { Text("Task Name") },
                singleLine = true
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                value = taskDescription,
                onValueChange = { taskDescription = it },
                label = { Text("Task Description") },
                minLines = 4
            )

            DropdownInput(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp),
                label = "Task Completed",
                options = listOf(
                    DropdownItem(
                        label = "Yes",
                        value = ValueYN.YES
                    ),
                    DropdownItem(
                        label = "No",
                        value = ValueYN.NO
                    )
                ),
                selectedValue = if (taskCompletedYN.value.isYes()) "Yes" else "No",
                onValueSelected = {
                    println(" ==> it $it")
                    taskCompletedYN = it
                    println("==> taskCompletedYN $taskCompletedYN")
                }
            )
        }
    }
}

data class DropdownItem(
    val label: String,
    val value: ValueYN
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownInput(
    label: String,
    options: List<DropdownItem>,
    selectedValue: String,
    onValueSelected: (ValueYN) -> Unit,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = selectedValue,
            onValueChange = {},
            readOnly = true,
            label = {
                Text(label)
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(option.label)
                    },
                    onClick = {
                        onValueSelected(option.value)
                        expanded = false
                    }
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun DropdownInputPreview() {
    DropdownInput(
        label = "Task Completed",
        options = listOf(
            DropdownItem(
                label = "Yes",
                value = ValueYN.YES
            ),
            DropdownItem(
                label = "No",
                value = ValueYN.NO
            )
        ),
        selectedValue = "Yes",
        onValueSelected = {}
    )
}


@Preview(showBackground = true)
@Composable
fun ScreenCreateTaskPreview() {
    BaseTheme {
        ScreenCreateTask() {
        }

    }
}