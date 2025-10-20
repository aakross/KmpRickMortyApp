package org.example.rickmortyapp.domain

class GetRandomCharacter(private val repository: Repository) {
    suspend operator fun invoke() {
        val random: Int = (1..826).random()
        repository.getSingleCharacter(random.toString())
    }
}