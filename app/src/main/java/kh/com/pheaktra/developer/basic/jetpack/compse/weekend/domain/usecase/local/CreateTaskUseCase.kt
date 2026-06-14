package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.usecase.local

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.BaseUseCase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.TaskModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CreateTaskUseCase @Inject constructor(
    private val taskRepository: TaskRepository
) : BaseUseCase<TaskModel, Flow<BaseUiState<Unit>>>() {

    override suspend fun execute(params: TaskModel): Flow<BaseUiState<Unit>> {
        return flow {
            taskRepository.createTask(params)
            emit(BaseUiState.Success(Unit))
        }
    }
}