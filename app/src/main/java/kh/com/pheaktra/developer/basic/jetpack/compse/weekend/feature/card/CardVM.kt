package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.card

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pheaktra.developer.base.core.BaseViewModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.CardModel
import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.base.BaseUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CardVM(
    private val cardRepository: CardRepository = CardRepository()
) : BaseViewModel() {
    private var _cardListUiState: MutableStateFlow<BaseUiState<List<CardModel>>> =
        MutableStateFlow(BaseUiState.None)
    var cardListUiState = _cardListUiState.asStateFlow()

    fun getCardList() {
        viewModelScope.launch {
            _cardListUiState.emit(BaseUiState.Loading)

            cardRepository.getMessage().collect { data ->
                _cardListUiState.emit(BaseUiState.Success(data))
            }
        }
    }

    init {
        getCardList()
    }
}