package kh.com.pheaktra.developer.android.domain.usecase.local

import kh.com.pheaktra.developer.android.domain.BaseNoneUseCase
import kh.com.pheaktra.developer.android.domain.model.TaskModel
import kh.com.pheaktra.developer.android.domain.repository.TaskRepository
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.base.BaseUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GetTaskListUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) : BaseNoneUseCase<Unit, Flow<BaseUiState<List<TaskModel>>>>() {
    override fun execute(params: Unit): Flow<BaseUiState<List<TaskModel>>> {
        return taskRepository.getTasks()
            .map<List<TaskModel>, BaseUiState<List<TaskModel>>> {
                BaseUiState.Success(it)
            }
            .onStart {
                emit(BaseUiState.Loading)
            }
            .catch { e ->
                emit(BaseUiState.ErrorException(e.message ?: ""))
            }
    }
}