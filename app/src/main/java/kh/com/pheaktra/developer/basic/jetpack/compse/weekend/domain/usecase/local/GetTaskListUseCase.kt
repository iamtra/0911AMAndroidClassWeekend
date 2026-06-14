package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.usecase.local

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.BaseNoneUseCase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.BaseUseCase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.TaskModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import okio.IOException
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