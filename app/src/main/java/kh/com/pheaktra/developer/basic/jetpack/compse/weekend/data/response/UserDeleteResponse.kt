package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.data.response

import kotlinx.serialization.Serializable

@Serializable
data class UserDeleteResponse(
    val message: String,
    val data: UserModelResponse
)