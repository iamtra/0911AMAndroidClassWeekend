package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response

import kotlinx.serialization.Serializable


@Serializable
data class UserUpdateResponse(
    val message: String,
    val data: UserModelResponse
)

