package org.example.rickmortyapp.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import org.example.rickmortyapp.data.database.dao.UserPreferencesDAO
import org.example.rickmortyapp.data.database.entity.CharacterOfTheDayEntity

const val DATABASE_NAME = "rm_app_database.db"

expect object RickMortyCTor : RoomDatabaseConstructor<RickMortyDatabase>

//Las entities van a ser los modelos de datos que necesitamos o que utiliza nuestra base de datos y es un arreglo

@Database(entities = [CharacterOfTheDayEntity::class], version = 1)
@ConstructedBy(RickMortyCTor::class)
abstract class RickMortyDatabase : RoomDatabase() {
//DAO significa Data Access Object Es como una barrera para acceder a la informacion de las entidades
    abstract fun getPreferenceDao(): UserPreferencesDAO
}