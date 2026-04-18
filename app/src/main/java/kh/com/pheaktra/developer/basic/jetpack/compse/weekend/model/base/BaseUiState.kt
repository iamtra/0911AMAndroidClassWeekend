package kh.com.pheaktra.developer.basic.jetpack.compse.weekend.model.base

/**
 * A generic class that holds a value with its loading status.
 * @param T the type of the data being held in [Success].
 */
sealed class BaseUiState<out T> {
    /**
     * Initial state before any action is taken.
     */
    data object None : BaseUiState<Nothing>()

    /**
     * State representing an active loading process.
     */
    data object Loading : BaseUiState<Nothing>()

    /**
     * State representing a successful operation with data.
     */
    data class Success<out T>(val data: T) : BaseUiState<T>()


    data class Error(val code: Int, val message: String): BaseUiState<Nothing>()

    /**
     * State representing a failed operation.
     */
    data class ErrorException(
        val message: String,
        val throwable: Throwable? = null
    ) : BaseUiState<Nothing>()
}
