package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.usecase

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.BaseUseCase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserListResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val repository: UserRepository
) : BaseUseCase<Unit, Flow<BaseUiState<UserListResponse>>>() {
    override suspend fun execute(params: Unit): Flow<BaseUiState<UserListResponse>> {
        return flow {
            try {
                emit(BaseUiState.Loading)

                val response = repository.getUsers()

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