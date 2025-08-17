package compose.about.me.data.setting.repository

import compose.about.me.common.model.ProjectThemeType
import compose.about.me.common.result.ProjectResult
import kotlinx.coroutines.flow.Flow

interface SettingRepository {
    fun getThemePreferences(): Flow<ProjectThemeType>
    fun saveThemePreferences(theme: ProjectThemeType): Flow<ProjectResult<Unit>>
}
