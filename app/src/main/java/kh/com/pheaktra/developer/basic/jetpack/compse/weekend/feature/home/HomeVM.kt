package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.ComponentModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.base.BaseUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeVM(
    private val homeRepository: HomeRepository = HomeRepository()
) : ViewModel() {
    private var _componentList: MutableStateFlow<BaseUiState<List<ComponentModel>>> = MutableStateFlow(BaseUiState.None)
    val componentList = _componentList.asStateFlow()


    fun getComponentList() {
        viewModelScope.launch {
            homeRepository.getMessage().collect {
                _componentList.value = BaseUiState.Success(it)
            }
        }
    }


    init {
        getComponentList()
    }
}