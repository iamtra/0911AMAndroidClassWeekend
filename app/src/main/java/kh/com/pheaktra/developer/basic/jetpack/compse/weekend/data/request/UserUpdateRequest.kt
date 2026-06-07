package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.request

import kotlinx.serialization.Serializable

@Serializable
data class UserUpdateRequest(
    val id: String = "",
    val name: String,
    val email: String
)
