package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.roomdatabase

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.retain.retain
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.R
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.common.ValueYN
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.TaskModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.isCompleted
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.roomdatabase.bottmsheet.TaskActionBottomSheet
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.ui.theme.BaseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRoomDatabase(
    roomVM: RoomVM = viewModel(),
    onBack: () -> Unit,
    onCreateTask: () -> Unit,
    onEditTask: (TaskModel) -> Unit
) {

    val taskListUiState by roomVM.taskListUiState.collectAsStateWithLifecycle()

    var isLongPress by remember { mutableStateOf(false) }
    var task by retain { mutableStateOf<TaskModel?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            modifier = Modifier.size(648.dp),
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Room Database",
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    actionIconContentColor = Color.Blue,
                    titleContentColor = Color.DarkGray
                )
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    onCreateTask()
                },
                icon = { Icon(Icons.Filled.Add, "Extended floating action button.") },
                text = { Text(text = "New Task") },
            )
        }
    ) { padding ->
        if (taskListUiState is BaseUiState.Success) {
            val taskList = (taskListUiState as BaseUiState.Success<List<TaskModel>>).data

            if (taskList.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    items(taskList.size) { index ->
                        TaskItem(
                            modifier = Modifier
                                .padding(vertical = 8.dp)
                                .padding(horizontal = 16.dp),
                            task = taskList[index],
                            onClick = {
                                onEditTask(it)
                            },
                            onLongClick = { value ->
                                isLongPress = true
                                task = value
                            },
                            onClickRadioButton = {
                                val task = it.copy(
                                    taskCompletedYN = if (it.isCompleted()) ValueYN.NO else ValueYN.YES
                                )

                                roomVM.updateTask(task)
                            }
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(64.dp))
                    }
                }
            } else {
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("No task data")
                }
            }
        }

        if (isLongPress) {
            TaskActionBottomSheet(
                onDelete = {
                    isLongPress = false
                    task?.let {
                        roomVM.deleteTask(it)
                    }
                },
                onEdit = {
                    isLongPress = false
                    task?.let {
                        onEditTask(it)
                    }
                }
            )
        }
    }
}

@Composable
fun TaskItem(
    modifier: Modifier = Modifier,
    task: TaskModel,
    onClick: (TaskModel) -> Unit,
    onLongClick: (TaskModel) -> Unit = {},
    onClickRadioButton: (TaskModel) -> Unit
) {
    Row(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth()
            .height(96.dp)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                width = 2.dp,
                color = if (task.isCompleted()) MaterialTheme.colorScheme.error
                else MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(16.dp),
            )
            .combinedClickable(
                onClick = {
                    onClick.invoke(task)
                },
                onLongClick = {
                    onLongClick.invoke(task)
                }
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 8.dp)
                .padding(start = 16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(1f),
                text = task.taskName,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleLarge,
                textDecoration = if (task.isCompleted()) TextDecoration.LineThrough else null
            )
            Text(
                text = task.taskDescription,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        RadioButton(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            selected = task.taskCompletedYN == ValueYN.YES,
            onClick = {
                onClickRadioButton.invoke(task)
            },
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colorScheme.primary,
                unselectedColor = MaterialTheme.colorScheme.onBackground
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskItemPreview() {
    BaseTheme {
        TaskItem(
            task = TaskModel(
                taskId = 1,
                taskName = "Task 1",
                taskDescription = "Hello Kon papa",
                taskCompletedYN = ValueYN.YES
            ),
            onClick = {},
            onClickRadioButton = {}
        )
    }
}

//@Composable
//@Preview(showBackground = true)
//fun ScreenRoomDatabasePreview() {
//    BaseTheme {
//        ScreenRoomDatabase() {
//        }
//
//    }
//}