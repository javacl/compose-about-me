package compose.about.me.data.setting.di

import compose.about.me.data.setting.repository.SettingRepository
import compose.about.me.data.setting.repository.SettingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface SettingDataModule {

    @Binds
    fun bindSettingRepository(
        settingRepositoryImpl: SettingRepositoryImpl
    ): SettingRepository
}
