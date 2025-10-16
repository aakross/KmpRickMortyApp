package org.example.rickmortyapp


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.example.rickmortyapp.ui.core.navigation.NavigationWrapper
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }
}