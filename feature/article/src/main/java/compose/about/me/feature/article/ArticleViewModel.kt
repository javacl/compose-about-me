package compose.about.me.feature.article

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import compose.about.me.common.network.dispatcher.DispatcherProvider
import compose.about.me.design.system.base.BaseViewModel
import compose.about.me.domain.article.use_case.GetArticleLocalUseCase
import compose.about.me.feature.article.mapper.toArticleModel
import compose.about.me.feature.article.navigation.ArticleArgs
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
internal class ArticleViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    savedStateHandle: SavedStateHandle,
    getArticleLocalUseCase: GetArticleLocalUseCase
) : BaseViewModel(dispatcherProvider), ArticleContract {

    private val args = ArticleArgs(savedStateHandle)

    private val mutableState = MutableStateFlow(ArticleContract.State())
    override val state: StateFlow<ArticleContract.State> = mutableState.asStateFlow()

    override fun event(event: ArticleContract.Event) {}

    init {
        getArticleLocalUseCase(
            id = args.id
        )
            .onEach { article ->
                mutableState.update { state ->
                    state.copy(
                        article = article?.toArticleModel()
                    )
                }
            }
            .catch {}
            .launchIn(viewModelScope)
    }
}
