package kh.com.pheaktra.developer.android.domain.usecase.local

import javax.inject.Inject
import kh.com.pheaktra.developer.android.domain.BaseUseCase
import kh.com.pheaktra.developer.android.domain.model.TaskModel
import kh.com.pheaktra.developer.android.domain.repository.TaskRepository
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.base.BaseUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class DeleteTaskUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) : BaseUseCase<TaskModel, Flow<BaseUiState<Unit>>>() {

    override suspend fun execute(params: TaskModel): Flow<BaseUiState<Unit>> {
        return flow {
            taskRepository.deleteTask(params.taskId)
            emit(BaseUiState.Success(Unit))
        }
    }
}