package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeVM(
    private val homeRepository: HomeRepository = HomeRepository()
) : ViewModel() {
    private var _message: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val message = _message.asStateFlow()

    fun getMessage() {
        viewModelScope.launch {
           _message.emit(homeRepository.getMessage())
        }
    }
}