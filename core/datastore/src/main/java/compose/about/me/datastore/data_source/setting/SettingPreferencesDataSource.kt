package compose.about.me.datastore.data_source.setting

import kotlinx.coroutines.flow.Flow

interface SettingPreferencesDataSource {
    fun getTheme(): Flow<Int?>
    suspend fun saveTheme(theme: Int)
}
