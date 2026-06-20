package kh.com.pheaktra.developer.android.domain.repository

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.request.CreateUserRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.request.UserUpdateRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response.UserCreateResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response.UserDeleteResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response.UserListResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response.UserUpdateResponse
import retrofit2.Response

interface UserRepository {

    suspend fun getUsers() : Response<UserListResponse>

    suspend fun createUser(body: CreateUserRequest) : Response<UserCreateResponse>

    suspend fun updateUser(id: String, body: UserUpdateRequest) : Response<UserUpdateResponse>

    suspend fun deleteUser(id: String) : Response<UserDeleteResponse>
}