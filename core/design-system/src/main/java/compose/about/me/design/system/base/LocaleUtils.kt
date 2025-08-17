package compose.about.me.design.system.base

import android.content.Context
import java.util.Locale

fun localizedContext(
    baseContext: Context,
    locale: Locale = Locale.Builder()
        .setLanguage("en")
        .setRegion("US")
        .build()
): Context {
    Locale.setDefault(locale)
    val configuration = baseContext.resources.configuration
    configuration.setLocale(locale)
    configuration.setLayoutDirection(locale)
    return baseContext.createConfigurationContext(configuration)
}
