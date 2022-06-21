package com.compose.navigation.core.util.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.navigation.R
import com.compose.navigation.core.util.ExceptionHelper
import com.compose.navigation.core.util.Exceptions
import com.compose.navigation.core.util.model.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext

abstract class BaseViewModel : ViewModel() {

    protected val coroutineContext = viewModelScope.coroutineContext + Dispatchers.IO

    private val _networkViewState = MutableStateFlow(getNetworkViewState())
    val networkViewState: Flow<NetworkViewState>
        get() = _networkViewState

    data class NetworkViewState(
        val showProgress: Boolean,
        val showProgressMore: Boolean,
        val showSuccess: Boolean,
        val showError: Boolean,
        val showValidationError: Boolean,
        val serverErrorMessage: String?,
        val errorMessage: Int,
        val errorIcon: Int,
        val requestTag: String?,
        val validationError: Any?,
        val unauthorized: Boolean,
        val data: Any?
    )

    private fun getNetworkViewState(
        showProgress: Boolean = false,
        showProgressMore: Boolean = false,
        showSuccess: Boolean = false,
        showError: Boolean = false,
        showValidationError: Boolean = false,
        serverErrorMessage: String? = null,
        errorMessage: Int = R.string.error_general,
        errorIcon: Int = R.drawable.ic_general_error,
        requestTag: String? = null,
        validationError: Any? = null,
        unauthorized: Boolean = false,
        data: Any? = null
    ) = NetworkViewState(
        showProgress,
        showProgressMore,
        showSuccess,
        showError,
        showValidationError,
        serverErrorMessage,
        errorMessage,
        errorIcon,
        requestTag,
        validationError,
        unauthorized,
        data
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
            getNetworkViewState(
                showProgress = true,
                requestTag = requestTag
            )
        )
    }

    protected suspend fun networkMoreLoading(requestTag: String? = null) {
        emitNetworkViewState(
            getNetworkViewState(
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
                getNetworkViewState(showSuccess = true)
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
                getNetworkViewState(
                    showSuccess = true,
                    data = castData(result, requestTag),
                    requestTag = requestTag
                )
            }
            is ApiResult.Error -> {
                if (result.exception is Exceptions.ValidationException<*>) {
                    getNetworkViewState(
                        showValidationError = true,
                        validationError = result.exception.errors,
                        requestTag = requestTag
                    )
                } else {
                    val errorView = ExceptionHelper.getError(result.exception)
                    getNetworkViewState(
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
