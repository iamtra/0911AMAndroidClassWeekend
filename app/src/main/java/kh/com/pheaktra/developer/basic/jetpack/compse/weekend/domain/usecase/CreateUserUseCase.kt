package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.usecase

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.BaseUseCase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.request.CreateUserRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.response.UserCreateResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(
    private val repository: UserRepository
) : BaseUseCase<CreateUserRequest, Flow<BaseUiState<UserCreateResponse>>>() {
    override suspend fun execute(params: CreateUserRequest): Flow<BaseUiState<UserCreateResponse>> {
        return flow {
            try {
                emit(BaseUiState.Loading)

                val response = repository.createUser(params)

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