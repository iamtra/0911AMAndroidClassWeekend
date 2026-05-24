package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.request

import kotlinx.serialization.Serializable

@Serializable
data class UserUpdateRequest(
    val name: String,
    val email: String
)
