package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.network

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.request.CreateUserRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.request.UserUpdateRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response.UserCreateResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response.UserDeleteResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response.UserListResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response.UserUpdateResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("users")
    suspend fun getUsers(): UserListResponse

    @POST("users")
    suspend fun createUser(@Body user: CreateUserRequest): UserCreateResponse

    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") id: String): UserDeleteResponse

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id") id: String, @Body user: UserUpdateRequest): Response<UserUpdateResponse>
}