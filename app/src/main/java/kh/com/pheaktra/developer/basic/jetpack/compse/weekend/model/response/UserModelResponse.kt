package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.response


data class UserListResponse(
    val message: String,
    val data: List<UserModelResponse>
)
data class UserModelResponse(
    val id: String,
    val name: String,
    val email: String
)

