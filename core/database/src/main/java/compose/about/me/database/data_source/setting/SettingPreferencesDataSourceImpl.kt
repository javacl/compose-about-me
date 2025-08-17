package compose.about.me.database.data_source.setting

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class SettingPreferencesDataSourceImpl @Inject constructor(
    @param:ApplicationContext private val context: Context
) : SettingPreferencesDataSource {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = context.applicationContext.packageName + ".setting"
    )

    private object PreferencesKeys {
        val theme = intPreferencesKey("theme")
    }

    override fun getTheme(): Flow<Int?> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.theme]
    }

    override suspend fun saveTheme(theme: Int) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.theme] = theme
        }
    }
}
