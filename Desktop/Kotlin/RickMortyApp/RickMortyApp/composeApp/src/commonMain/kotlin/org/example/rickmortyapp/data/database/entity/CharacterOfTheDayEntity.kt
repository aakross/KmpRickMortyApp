package org.example.rickmortyapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

//Siempre va a necesitar la anotacion entity cuando usemos room
@Entity(tableName = "characteroftheday")
data class CharacterOfTheDayEntity(
    @PrimaryKey //(autoGenerate = true)
    val id: Int,
    val isAlive: Boolean,
    val image: String,
    val name: String,
    val selectedDate: String
)
