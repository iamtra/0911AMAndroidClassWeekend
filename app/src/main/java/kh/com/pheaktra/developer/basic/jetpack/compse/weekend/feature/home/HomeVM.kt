package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.base.BaseUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeVM(
    private val homeRepository: HomeRepository = HomeRepository()
) : ViewModel() {
    private var _messageUiState: MutableStateFlow<BaseUiState<List<String>>> =
        MutableStateFlow(BaseUiState.None)
    val messageUiState = _messageUiState.asStateFlow()

    fun getMessage() {
        viewModelScope.launch {
            _messageUiState.emit(BaseUiState.Loading)
            delay(3000)
            _messageUiState.emit(BaseUiState.Success(homeRepository.getMessage()))
        }
    }

    init {
        getMessage()
    }
}