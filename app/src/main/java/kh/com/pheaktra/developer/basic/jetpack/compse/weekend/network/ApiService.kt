package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.network

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.UserModel
import retrofit2.http.*

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<UserModel>

    @POST("users")
    suspend fun createUser(@Body user: UserModel): UserModel
}