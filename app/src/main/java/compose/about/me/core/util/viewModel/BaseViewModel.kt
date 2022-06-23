package compose.about.me.core.util.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import compose.about.me.R
import compose.about.me.core.util.ExceptionHelper
import compose.about.me.core.util.Exceptions
import compose.about.me.core.util.model.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext

abstract class BaseViewModel : ViewModel() {

    protected val coroutineContext = viewModelScope.coroutineContext + Dispatchers.IO

    private val _networkViewState = MutableStateFlow(NetworkViewState())
    val networkViewState: Flow<NetworkViewState>
        get() = _networkViewState

    data class NetworkViewState(
        val showProgress: Boolean = false,
        val showProgressMore: Boolean = false,
        val showSuccess: Boolean = false,
        val showError: Boolean = false,
        val showValidationError: Boolean = false,
        val serverErrorMessage: String? = null,
        val errorMessage: Int = R.string.error_general,
        val errorIcon: Int = R.drawable.ic_general_error,
        val requestTag: String? = null,
        val validationError: Any? = null,
        val unauthorized: Boolean = false,
        val data: Any? = null
    )

    private suspend fun emitNetworkViewState(
        networkViewStates: NetworkViewState
    ) {
        withContext(Dispatchers.Main) {
            _networkViewState.emit(networkViewStates)
        }
    }

    protected suspend fun networkLoading(requestTag: String? = null) {
        emitNetworkViewState(
            NetworkViewState(
                showProgress = true,
                requestTag = requestTag
            )
        )
    }

    protected suspend fun networkMoreLoading(requestTag: String? = null) {
        emitNetworkViewState(
            NetworkViewState(
                showProgressMore = true,
                requestTag = requestTag
            )
        )
    }

    protected open suspend fun <T> observeNetworkState(
        vararg results: ApiResult<T>,
        requestTagList: List<String> = listOf()
    ) {
        var errorChecked = false
        var networkStateList: List<NetworkViewState> = mutableListOf()

        results.forEachIndexed { index, result ->

            if (result is ApiResult.Error && !errorChecked) {
                val networkViewState = getNetworkStateResult(result)
                emitNetworkViewState(networkViewState)
                errorChecked = true
            }

            // Check and get requestTag if existed
            val requestTag = requestTagList.elementAtOrNull(index)

            networkStateList = networkStateList.plus(getNetworkStateResult(result, requestTag))
        }


        // When all result become Success we have to handle them
        if (!errorChecked)
            emitNetworkViewState(
                NetworkViewState(showSuccess = true)
            )
    }

    protected open suspend fun <T> observeNetworkState(result: ApiResult<T>, requestTag: String) {
        emitNetworkViewState(getNetworkStateResult(result, requestTag))
    }

    private suspend fun <T> getNetworkStateResult(
        result: ApiResult<T>,
        requestTag: String? = null
    ): NetworkViewState {
        return when (result) {
            is ApiResult.Success -> {
                NetworkViewState(
                    showSuccess = true,
                    data = castData(result, requestTag),
                    requestTag = requestTag
                )
            }
            is ApiResult.Error -> {
                if (result.exception is Exceptions.ValidationException<*>) {
                    NetworkViewState(
                        showValidationError = true,
                        validationError = result.exception.errors,
                        requestTag = requestTag
                    )
                } else {
                    val errorView = ExceptionHelper.getError(result.exception)
                    NetworkViewState(
                        showError = true,
                        serverErrorMessage = errorView.serverErrorMessage,
                        errorMessage = errorView.message,
                        unauthorized = errorView.unauthorized,
                        errorIcon = errorView.icon,
                        requestTag = requestTag
                    )
                }
            }
        }
    }

    protected open suspend fun <T> castData(result: ApiResult<T>, requestTag: String?): Any? {
        return (result as ApiResult.Success).data
    }
}
