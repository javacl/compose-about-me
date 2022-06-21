package com.compose.navigation.core.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.compose.navigation.R

val FontName = FontFamily(
    Font(R.font.iran_yekan_light, FontWeight.Light),
    Font(R.font.iran_yekan_normal, FontWeight.Normal),
    Font(R.font.iran_yekan_medium, FontWeight.Medium),
    Font(R.font.iran_yekan_bold, FontWeight.Bold),
    Font(R.font.iran_yekan_extra_bold, FontWeight.ExtraBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = FontName
)

val BaseTextStyle = TextStyle(
    fontFamily = FontName
)

val TextStyleX1 = BaseTextStyle.copy(
    fontSize = 10.sp
)

val TextStyleX2 = BaseTextStyle.copy(
    fontSize = 12.sp
)

val TextStyleX3 = BaseTextStyle.copy(
    fontSize = 14.sp
)

val TextStyleX4 = BaseTextStyle.copy(
    fontSize = 16.sp
)

val TextStyleX5 = BaseTextStyle.copy(
    fontSize = 18.sp
)

val TextStyleX6 = BaseTextStyle.copy(
    fontSize = 20.sp
)

// Set TextStyle x1 size
val Typography.x1_light: TextStyle
    get() = TextStyleX1.copy(
        fontWeight = FontWeight.Light
    )

val Typography.x1_normal: TextStyle
    get() = TextStyleX1.copy(
        fontWeight = FontWeight.Normal
    )

val Typography.x1_medium: TextStyle
    get() = TextStyleX1.copy(
        fontWeight = FontWeight.Medium
    )

val Typography.x1_bold: TextStyle
    get() = TextStyleX1.copy(
        fontWeight = FontWeight.Bold
    )

val Typography.x1_extra_bold: TextStyle
    get() = TextStyleX1.copy(
        fontWeight = FontWeight.ExtraBold
    )

// Set TextStyle x2 size
val Typography.x2_light: TextStyle
    get() = TextStyleX2.copy(
        fontWeight = FontWeight.Light
    )

val Typography.x2_normal: TextStyle
    get() = TextStyleX2.copy(
        fontWeight = FontWeight.Normal
    )

val Typography.x2_medium: TextStyle
    get() = TextStyleX2.copy(
        fontWeight = FontWeight.Medium
    )

val Typography.x2_bold: TextStyle
    get() = TextStyleX2.copy(
        fontWeight = FontWeight.Bold
    )

val Typography.x2_extra_bold: TextStyle
    get() = TextStyleX2.copy(
        fontWeight = FontWeight.ExtraBold
    )

// Set TextStyle x3 size
val Typography.x3_light: TextStyle
    get() = TextStyleX3.copy(
        fontWeight = FontWeight.Light
    )

val Typography.x3_normal: TextStyle
    get() = TextStyleX3.copy(
        fontWeight = FontWeight.Normal
    )

val Typography.x3_medium: TextStyle
    get() = TextStyleX3.copy(
        fontWeight = FontWeight.Medium
    )

val Typography.x3_bold: TextStyle
    get() = TextStyleX3.copy(
        fontWeight = FontWeight.Bold
    )

val Typography.x3_extra_bold: TextStyle
    get() = TextStyleX3.copy(
        fontWeight = FontWeight.ExtraBold
    )

// Set TextStyle x4 size
val Typography.x4_light: TextStyle
    get() = TextStyleX4.copy(
        fontWeight = FontWeight.Light
    )

val Typography.x4_normal: TextStyle
    get() = TextStyleX4.copy(
        fontWeight = FontWeight.Normal
    )

val Typography.x4_medium: TextStyle
    get() = TextStyleX4.copy(
        fontWeight = FontWeight.Medium
    )

val Typography.x4_bold: TextStyle
    get() = TextStyleX4.copy(
        fontWeight = FontWeight.Bold
    )

val Typography.x4_extra_bold: TextStyle
    get() = TextStyleX4.copy(
        fontWeight = FontWeight.ExtraBold
    )

// Set TextStyle x5 size
val Typography.x5_light: TextStyle
    get() = TextStyleX5.copy(
        fontWeight = FontWeight.Light
    )

val Typography.x5_normal: TextStyle
    get() = TextStyleX5.copy(
        fontWeight = FontWeight.Normal
    )

val Typography.x5_medium: TextStyle
    get() = TextStyleX5.copy(
        fontWeight = FontWeight.Medium
    )

val Typography.x5_bold: TextStyle
    get() = TextStyleX5.copy(
        fontWeight = FontWeight.Bold
    )

val Typography.x5_extra_bold: TextStyle
    get() = TextStyleX5.copy(
        fontWeight = FontWeight.ExtraBold
    )

// Set TextStyle x6 size
val Typography.x6_light: TextStyle
    get() = TextStyleX6.copy(
        fontWeight = FontWeight.Light
    )

val Typography.x6_normal: TextStyle
    get() = TextStyleX6.copy(
        fontWeight = FontWeight.Normal
    )

val Typography.x6_medium: TextStyle
    get() = TextStyleX6.copy(
        fontWeight = FontWeight.Medium
    )

val Typography.x6_bold: TextStyle
    get() = TextStyleX6.copy(
        fontWeight = FontWeight.Bold
    )

val Typography.x6_extra_bold: TextStyle
    get() = TextStyleX6.copy(
        fontWeight = FontWeight.ExtraBold
    )
