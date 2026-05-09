package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.userapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.UserModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.base.BaseUiState
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserApiVM : ViewModel() {
    private var _userListUiState: MutableStateFlow<BaseUiState<List<UserModel>>> =
        MutableStateFlow(BaseUiState.None)
    val userListUiState = _userListUiState.asStateFlow()

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

    init {
        getUser()
    }
}