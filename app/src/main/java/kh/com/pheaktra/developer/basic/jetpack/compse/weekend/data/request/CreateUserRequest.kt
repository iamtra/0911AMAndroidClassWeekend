package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.request

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequest(
    val name: String,
    val email: String
)
