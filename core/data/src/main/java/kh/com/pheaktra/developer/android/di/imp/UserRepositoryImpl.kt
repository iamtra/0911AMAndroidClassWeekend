package kh.com.pheaktra.developer.android.di.imp

import kh.com.pheaktra.developer.android.network.ApiService
import kh.com.pheaktra.developer.android.domain.repository.UserRepository
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.request.CreateUserRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.request.UserUpdateRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response.UserCreateResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response.UserDeleteResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response.UserListResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response.UserUpdateResponse
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {
    override suspend fun getUsers(): Response<UserListResponse> {
        return apiService.getUsers()
    }

    override suspend fun createUser(body: CreateUserRequest): Response<UserCreateResponse> {
        return apiService.createUser(user = body)
    }

    override suspend fun updateUser(
        id: String,
        body: UserUpdateRequest
    ): Response<UserUpdateResponse> {
        return apiService.updateUser(id = id, user = body)
    }

    override suspend fun deleteUser(id: String): Response<UserDeleteResponse> {
        return apiService.deleteUser(id = id)
    }
}