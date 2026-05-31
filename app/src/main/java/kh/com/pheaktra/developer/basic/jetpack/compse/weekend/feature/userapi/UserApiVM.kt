package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.userapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.request.CreateUserRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.request.UserUpdateRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserCreateResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserDeleteResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserListResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserUpdateResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserApiVM : ViewModel() {
    private var _userListUiState: MutableStateFlow<BaseUiState<UserListResponse>> =
        MutableStateFlow(BaseUiState.None)
    val userListUiState = _userListUiState.asStateFlow()

    private var _createUserUiState: MutableStateFlow<BaseUiState<UserCreateResponse>> =
        MutableStateFlow(BaseUiState.None)
    val createUserUiState = _createUserUiState.asStateFlow()

    private var _userDeleteUiState: MutableStateFlow<BaseUiState<UserDeleteResponse>> =
        MutableStateFlow(BaseUiState.None)
    val userDeleteUiState = _userDeleteUiState.asStateFlow()

    private var _updateUserUiState: MutableStateFlow<BaseUiState<UserUpdateResponse>?> =
        MutableStateFlow(null)
    val updateUserUiState = _updateUserUiState.asStateFlow()


    fun getUser() {
        viewModelScope.launch {
            _userListUiState.value = BaseUiState.Loading
            try {
                val response = RetrofitClient.apiService.getUsers()
                _userListUiState.value = BaseUiState.Success(response)
            } catch (e: Exception) {
                e.printStackTrace()
                _userListUiState.value = BaseUiState.Error(500000, e.message.toString())
            }
        }
    }

    fun createUser(body: CreateUserRequest) {
        viewModelScope.launch {
            _userListUiState.value = BaseUiState.Loading
            try {
                val response = RetrofitClient.apiService.createUser(body)
                _createUserUiState.emit(BaseUiState.Success(response))
            } catch (e: Exception) {
                e.printStackTrace()
                _userListUiState.value = BaseUiState.Error(500000, e.message.toString())
            }
        }
    }

    fun updateUser(id: String, body: UserUpdateRequest) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.updateUser(id, body)
                if (response.isSuccessful) {
                    val updatedUser = response.body()
                    if (updatedUser != null) {
                        _updateUserUiState.value = BaseUiState.Success(updatedUser)
                    } else {
                        _updateUserUiState.value =
                            BaseUiState.Error(500000, "Failed to update user")
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _updateUserUiState.value = BaseUiState.ErrorException(500000.toString(), e)
            }
        }
    }

    fun deleteUser(id: String) {
        viewModelScope.launch {
            _userListUiState.value = BaseUiState.Loading
            try {
                val response = RetrofitClient.apiService.deleteUser(id)
                _userDeleteUiState.emit(BaseUiState.Success(response))
            } catch (e: Exception) {

            }
        }
    }

    fun onDispose() {
        _userListUiState.value = BaseUiState.None
        _createUserUiState.value = BaseUiState.None
        _userDeleteUiState.value = BaseUiState.None
    }

}