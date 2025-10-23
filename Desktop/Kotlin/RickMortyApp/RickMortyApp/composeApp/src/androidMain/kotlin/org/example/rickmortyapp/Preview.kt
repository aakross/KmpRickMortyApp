package org.example.rickmortyapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.rickmortyapp.domain.model.CharacterModel
import org.example.rickmortyapp.ui.home.tabs.characters.CharacterOfTheDay

@Preview
@Composable
fun Preview() {
    CharacterOfTheDay(CharacterModel(id = 3, image = "", isAlive = true, name = "Alan"))
}