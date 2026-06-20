package kh.com.pheaktra.developer.android.domain.usecase

import kh.com.pheaktra.developer.android.domain.BaseUseCase
import kh.com.pheaktra.developer.android.domain.repository.UserRepository
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.request.UserUpdateRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response.UserUpdateResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val repository: UserRepository
) : BaseUseCase<UserUpdateRequest, Flow<BaseUiState<UserUpdateResponse>>>() {
    override suspend fun execute(params: UserUpdateRequest): Flow<BaseUiState<UserUpdateResponse>> {
        return flow {
            try {
                emit(BaseUiState.Loading)

                val response = repository.updateUser(params.id, params)

                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(BaseUiState.Success(it))
                    }
                } else {
                    emit(BaseUiState.Error(response.code(), response.message()))
                }
            } catch (e: Exception) {
                emit(BaseUiState.ErrorException(e.message ?: "Unknown error"))
            }
        }
    }
}