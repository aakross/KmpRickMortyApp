package org.example.rickmortyapp.domain

import org.example.rickmortyapp.domain.model.CharacterModel

class GetRandomCharacter(private val repository: Repository) {
    //Al agregar el operator invoke desde donde se mande a llamar se llama y se ejecuta
    suspend operator fun invoke(): CharacterModel {
        val random: Int = (1..826).random()
        return repository.getSingleCharacter(random.toString())
    }
}