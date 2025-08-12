package compose.about.me.design.system.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val extraSmallShapeSize = 4.dp
val smallShapeSize = 8.dp
val mediumShapeSize = 12.dp
val largeShapeSize = 16.dp
val extraLargeShapeSize = 28.dp

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(extraSmallShapeSize),
    small = RoundedCornerShape(smallShapeSize),
    medium = RoundedCornerShape(mediumShapeSize),
    large = RoundedCornerShape(largeShapeSize),
    extraLarge = RoundedCornerShape(extraLargeShapeSize)
)
