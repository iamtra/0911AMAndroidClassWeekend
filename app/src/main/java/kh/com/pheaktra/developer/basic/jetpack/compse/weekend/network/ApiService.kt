package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.network

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.request.CreateUserRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.request.UserUpdateRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.response.UserCreateResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.response.UserDeleteResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.response.UserListResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.response.UserUpdateResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<UserListResponse>

    @POST("users")
    suspend fun createUser(@Body user: CreateUserRequest): Response<UserCreateResponse>

    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") id: String): Response<UserDeleteResponse>

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id") id: String, @Body user: UserUpdateRequest): Response<UserUpdateResponse>
}