package org.example.rickmortyapp.data

import org.example.rickmortyapp.data.remote.ApiService
import org.example.rickmortyapp.domain.Repository
import org.example.rickmortyapp.domain.model.CharacterModel

class RepositoryImpl(val api: ApiService) : Repository {
    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }
}