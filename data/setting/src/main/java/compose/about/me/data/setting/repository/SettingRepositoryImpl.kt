package compose.about.me.data.setting.repository

import compose.about.me.common.model.ProjectThemeType
import compose.about.me.common.result.ProjectResult
import compose.about.me.datastore.data_source.setting.SettingPreferencesDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class SettingRepositoryImpl @Inject constructor(
    private val settingPreferencesDataSource: SettingPreferencesDataSource
) : SettingRepository {

    override fun getThemePreferences(): Flow<ProjectThemeType> =
        settingPreferencesDataSource.getTheme().map {
            when (it) {
                ProjectThemeType.Light.value -> ProjectThemeType.Light
                ProjectThemeType.Dark.value -> ProjectThemeType.Dark
                else -> ProjectThemeType.Default
            }
        }

    override fun saveThemePreferences(
        theme: ProjectThemeType
    ): Flow<ProjectResult<Unit>> = flow {
        emit(
            ProjectResult.Success(
                settingPreferencesDataSource.saveTheme(
                    theme = theme.value
                )
            )
        )
    }
}
