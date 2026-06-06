package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.userapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.request.CreateUserRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.request.UserUpdateRequest
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserCreateResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserDeleteResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserListResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.model.response.UserUpdateResponse
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.usecase.CreateUserUseCase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.usecase.DeleteUserUseCase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.usecase.GetUserListUseCase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.domain.usecase.UpdateUserUseCase
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class UserApiVM @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase,
    private val createUserUseCase: CreateUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
) : ViewModel() {
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
           getUserListUseCase.invoke(Unit)
               .collect {
                   _userListUiState.value = it
               }
        }
    }

    fun createUser(body: CreateUserRequest) {
        viewModelScope.launch {
            createUserUseCase.invoke(body)
                .collect {
                    _createUserUiState.value = it
                }
        }
    }

    fun updateUser(body: UserUpdateRequest) {
        viewModelScope.launch {
            updateUserUseCase.invoke(body)
                .collect {
                    _updateUserUiState.value = it
                }
        }
    }

    fun deleteUser(id: String) {
        viewModelScope.launch {
            deleteUserUseCase.invoke(id)
                .collect {
                    _userDeleteUiState.value = it
                }
        }
    }

    fun onDispose() {
        _userListUiState.value = BaseUiState.None
        _createUserUiState.value = BaseUiState.None
        _userDeleteUiState.value = BaseUiState.None
    }

}