package compose.about.me.design.system.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import compose.about.me.design.system.R

private val fontFamily = FontFamily(
    Font(R.font.roboto_regular, FontWeight.W400),
    Font(R.font.roboto_medium, FontWeight.W500),
    Font(R.font.roboto_bold, FontWeight.W700)
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = 57.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 64.sp
    ),
    displayMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = 45.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 52.sp
    ),
    displaySmall = TextStyle(
        fontFamily = fontFamily,
        fontSize = 36.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 44.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 40.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = 28.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 36.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = fontFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 32.sp
    ),
    titleLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = 18.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 28.sp
    ),
    titleMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 24.sp
    ),
    titleSmall = TextStyle(
        fontFamily = fontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = fontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 20.sp
    ),
    labelMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = fontFamily,
        fontSize = 10.sp,
        fontWeight = FontWeight.W500,
        lineHeight = 14.sp
    )
)
