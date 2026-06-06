package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.repository

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.request.CreateUserRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.request.UserUpdateRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserCreateResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserDeleteResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserListResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserUpdateResponse
import retrofit2.Response

interface UserRepository {

    suspend fun getUsers() : Response<UserListResponse>

    suspend fun createUser(body: CreateUserRequest) : Response<UserCreateResponse>

    suspend fun updateUser(id: String, body: UserUpdateRequest) : Response<UserUpdateResponse>

    suspend fun deleteUser(id: String) : Response<UserDeleteResponse>
}