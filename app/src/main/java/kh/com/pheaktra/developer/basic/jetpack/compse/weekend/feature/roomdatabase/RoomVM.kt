package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.roomdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.common.eventbus.Subscribe
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.TaskModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.usecase.local.CreateTaskUseCase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.usecase.local.DeleteTaskUseCase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.usecase.local.GetTaskListUseCase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.usecase.local.UpdateTaskUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class RoomVM @Inject constructor(
    getTaskListUseCase: GetTaskListUseCase,
    private val createTaskUseCase: CreateTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModel() {

    val taskListUiState: StateFlow<BaseUiState<List<TaskModel>>> =
        getTaskListUseCase.invoke(Unit)
            .stateIn(
                scope = viewModelScope,
                initialValue = BaseUiState.None,
                started = SharingStarted.WhileSubscribed(5_000),
            )

    fun createTask(task: TaskModel) {
        viewModelScope.launch {
            createTaskUseCase.invoke(task).collect {
                println(it)
            }
        }
    }

    fun updateTask(task: TaskModel) {
        viewModelScope.launch {
            updateTaskUseCase.invoke(task).collect {
                println(it)
            }
        }
    }

    fun deleteTask(task: TaskModel) {
        viewModelScope.launch {
            deleteTaskUseCase.invoke(task).collect {
                println(it)
            }
        }
    }
}

/**
 * 1. Testing create new task (Done)
 * 2. Improve Ui (Done)
 * 3. Implement update task
 * 4. Implement delete task
 * 5. Implement autofocus input task
 * 6. Implement keyboard software controller
 */