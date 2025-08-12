package compose.about.me.common.network.di

import compose.about.me.common.network.dispatcher.DispatcherProvider
import compose.about.me.common.network.dispatcher.DispatcherProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DispatcherModule {

    @Binds
    fun bindDispatcherProvider(impl: DispatcherProviderImpl): DispatcherProvider
}
