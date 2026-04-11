package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.feature.home


class HomeRepository {
    private val messageList = List(100) { index -> "This is message ${index + 1}" }
    fun getMessage(): List<String> {
        return messageList
    }
}