package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.card

import kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.CardModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CardRepository {

    private val cardList = List(100) { index ->
        CardModel(
            cardId = (index + 1).toString(),
            title = "Title ${index + 1}",
            description = "This is message ${index + 1}"
        )
    }

    suspend fun getMessage(): Flow<List<CardModel>> {
        delay(1000) // simulate network/database delay
        return flow {
            emit(cardList)
        }
    }
}