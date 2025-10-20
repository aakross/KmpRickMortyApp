package org.example.rickmortyapp

import android.app.Application
import org.example.rickmortyapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

//Aqui le estamos diciendo que antes de abrir la app ejecute esta clase, aqui estamos configurando koin en los ficheros de Android
class RickMortyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@RickMortyApp)
        }
    }
}