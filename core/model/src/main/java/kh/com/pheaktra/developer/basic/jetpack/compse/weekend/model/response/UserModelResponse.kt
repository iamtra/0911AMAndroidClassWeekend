package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserListResponse(
    val message: String,
    val data: List<UserModelResponse>
)

@Serializable
data class UserModelResponse(
    @SerialName("user_id")
    val id: String,
    @SerialName("user_name")
    val name: String,
    @SerialName("user_email")
    val email: String
)