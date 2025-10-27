package org.example.rickmortyapp.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import org.example.rickmortyapp.data.database.entity.CharacterOfTheDayEntity

//El dao es donde hacemos las consultas sql
@Dao
interface UserPreferencesDAO {
    @Query("SELECT * FROM characteroftheday")
    suspend fun getCharacterOfTheDayDB(): CharacterOfTheDayEntity?
}