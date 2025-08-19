package compose.about.me.feature.articles

import androidx.lifecycle.viewModelScope
import compose.about.me.common.network.dispatcher.DispatcherProvider
import compose.about.me.common.result.ProjectResult
import compose.about.me.design.system.base.BaseViewModel
import compose.about.me.domain.articles.use_case.GetArticlesLocalUseCase
import compose.about.me.domain.articles.use_case.GetArticlesRemoteUseCase
import compose.about.me.feature.articles.mapper.toArticleModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class ArticlesViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    getArticlesLocalUseCase: GetArticlesLocalUseCase,
    private val getArticlesRemoteUseCase: GetArticlesRemoteUseCase
) : BaseViewModel(dispatcherProvider), ArticlesContract {

    private val mutableState = MutableStateFlow(ArticlesContract.State())
    override val state: StateFlow<ArticlesContract.State> = mutableState.asStateFlow()

    override fun event(event: ArticlesContract.Event) = when (event) {
        is ArticlesContract.Event.OnRefresh -> refresh()
        is ArticlesContract.Event.OnGetData -> getData()
    }

    init {
        event(ArticlesContract.Event.OnRefresh)

        getArticlesLocalUseCase()
            .onEach { articles ->
                mutableState.update { state ->
                    state.copy(
                        articles = articles.map { it.toArticleModel() }
                    )
                }
            }
            .catch {}
            .launchIn(viewModelScope)
    }

    private var page = 1

    private fun getData(isRefresh: Boolean = false) {
        mutableState.update { state ->
            state.copy(
                errorException = null,
                loading = isRefresh,
                loadingMore = !isRefresh
            )
        }
        getArticlesRemoteUseCase(
            page = page
        )
            .onEach { result ->
                when (result) {
                    is ProjectResult.Error -> {
                        mutableState.update { state ->
                            state.copy(
                                errorException = result.exception,
                                loading = false,
                                loadingMore = false
                            )
                        }
                    }

                    is ProjectResult.Success -> {
                        page++
                        mutableState.update { state ->
                            state.copy(
                                errorException = null,
                                loading = false,
                                loadingMore = false
                            )
                        }
                    }
                }
            }
            .catch {}
            .launchIn(viewModelScope)
    }

    private fun refresh() {
        page = 1
        getData(isRefresh = true)
    }
}
