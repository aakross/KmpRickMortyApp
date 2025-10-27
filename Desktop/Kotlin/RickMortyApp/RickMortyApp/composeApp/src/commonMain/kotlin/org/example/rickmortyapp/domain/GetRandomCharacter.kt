package org.example.rickmortyapp.domain

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.example.rickmortyapp.domain.model.CharacterModel
import kotlinx.datetime.Instant

class GetRandomCharacter(private val repository: Repository) {
    //Al agregar el operator invoke desde donde se mande a llamar se llama y se ejecuta
    suspend operator fun invoke(): CharacterModel {

//        val  characterDataBase = repository.getSavedCharacter()

//        if (getCurrentDayOfTheYear() == characterDataBase.date) {
//        } else {        }

        repository.getCharacterDB()
        val random: Int = (1..826).random()
        return repository.getSingleCharacter(random.toString())
    }

    private fun getCurrentDayOfTheYear(): String {
        val instant: Instant = Clock.System.now()
        val localTime: LocalDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        localTime.dayOfYear
        localTime.year
        return "${localTime.dayOfYear}${localTime.year}"
    }

}