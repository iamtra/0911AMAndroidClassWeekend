package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.di.imp

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.request.CreateUserRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.request.UserUpdateRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserCreateResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserDeleteResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserListResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserUpdateResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.repository.UserRepository
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.network.ApiService
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