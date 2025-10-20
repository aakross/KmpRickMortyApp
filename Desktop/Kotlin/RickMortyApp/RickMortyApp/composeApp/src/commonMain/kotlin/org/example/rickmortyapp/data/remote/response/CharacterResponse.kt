package org.example.rickmortyapp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.rickmortyapp.domain.model.CharacterModel

//Esto es para convertir los datos a Json
//Con el SerialName podemos asignarle otro nombre al dato que recibimos en este caso id se llamara parameter
@Serializable
data class CharacterResponse(
//    @SerialName("id") val parameter: String,
    val id: String,
    val status: String,
    val image: String
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id,
            image = image,
            isAlive = status.lowercase() == "alive"
        )
    }
}