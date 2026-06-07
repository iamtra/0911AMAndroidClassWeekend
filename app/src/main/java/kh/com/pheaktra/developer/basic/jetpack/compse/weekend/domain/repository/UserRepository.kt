package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.repository

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.request.CreateUserRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.request.UserUpdateRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.response.UserCreateResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.response.UserDeleteResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.response.UserListResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.response.UserUpdateResponse
import retrofit2.Response

interface UserRepository {

    suspend fun getUsers() : Response<UserListResponse>

    suspend fun createUser(body: CreateUserRequest) : Response<UserCreateResponse>

    suspend fun updateUser(id: String, body: UserUpdateRequest) : Response<UserUpdateResponse>

    suspend fun deleteUser(id: String) : Response<UserDeleteResponse>
}