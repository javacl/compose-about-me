package compose.about.me.feature.article

import compose.about.me.common.network.dispatcher.DispatcherProvider
import compose.about.me.design.system.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class ArticleViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider
) : BaseViewModel(dispatcherProvider) {
}
