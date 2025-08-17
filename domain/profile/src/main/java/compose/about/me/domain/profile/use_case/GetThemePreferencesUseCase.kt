package compose.about.me.domain.profile.use_case

import compose.about.me.data.setting.repository.SettingRepository
import javax.inject.Inject

class GetThemePreferencesUseCase @Inject constructor(
    private val settingRepository: SettingRepository
) {
    operator fun invoke() = settingRepository.getThemePreferences()
}
