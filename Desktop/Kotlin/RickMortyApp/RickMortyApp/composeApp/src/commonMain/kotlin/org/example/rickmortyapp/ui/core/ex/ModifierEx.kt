package org.example.rickmortyapp.ui.core.ex

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

fun Modifier.vertical() = layout { measurable, constrains ->
    val placeable = measurable.measure(constrains)
    layout(placeable.height, placeable.width) {
        placeable.place(
            x = -((placeable.width / 2) - (placeable.height / 2)),
            y = -((placeable.height / 2) - (placeable.width / 2))
        )
    }
}