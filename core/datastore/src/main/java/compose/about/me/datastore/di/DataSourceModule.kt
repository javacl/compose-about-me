package compose.about.me.datastore.di

import compose.about.me.datastore.data_source.setting.SettingPreferencesDataSource
import compose.about.me.datastore.data_source.setting.SettingPreferencesDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataSourceModule {

    @Binds
    fun bindSettingPreferencesDataSource(
        settingPreferencesDataSourceImpl: SettingPreferencesDataSourceImpl
    ): SettingPreferencesDataSource
}
