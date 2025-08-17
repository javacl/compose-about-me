package compose.about.me.domain.profile.use_case

import compose.about.me.common.model.ProjectThemeType
import compose.about.me.data.setting.repository.SettingRepository
import javax.inject.Inject

class SaveThemePreferencesUseCase @Inject constructor(
    private val settingRepository: SettingRepository
) {
    operator fun invoke(
        theme: ProjectThemeType
    ) = settingRepository.saveThemePreferences(
        theme = theme
    )
}
