package com.check.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(5.dp),
    large = RoundedCornerShape(10.dp),
)

val Shapes_MediumX: RoundedCornerShape = RoundedCornerShape(12.5.dp)
val SmallRoundedCornerImage = RoundedCornerShape(6.dp)
val MediumRoundedCornerImage = RoundedCornerShape(8.dp)

val SmallRoundedCornerCard = RoundedCornerShape(6.dp)

val LocalAbsShape = compositionLocalOf { Shapes }
