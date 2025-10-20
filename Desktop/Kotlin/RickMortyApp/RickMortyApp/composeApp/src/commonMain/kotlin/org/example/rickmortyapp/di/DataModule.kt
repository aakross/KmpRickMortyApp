package org.example.rickmortyapp.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.rickmortyapp.data.RepositoryImpl
import org.example.rickmortyapp.data.remote.ApiService
import org.example.rickmortyapp.domain.Repository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

// Aqui el data se encarga de recibir la info de la api y convertirla a Json para que la podamos interpretar
val dataModule = module {
    //El single es para tener una sola instancia, quiere decir que cada vez que se llama a esto no cree un nuevo objeto sino queremos el mismo si existe si no lo crea
    single {
        HttpClient {
            install(ContentNegotiation) {
                //Aqui le estamos diciendo el trato que queremos darle a los json, si llega un dato que no conocemos no va a reventar por el ignoreUnKnownKeys
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            //Para las llamadas por defecto si no le decimos lo contrario hara lo que le pongamos dentro del install con el DefaultRequest
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    //Para ios no funciona si agregamos el "/" como esto rickandmortyapi.com, ademos el https se lo quitamos porque ya lo estamos declarando arriba
                    host = "rickandmortyapi.com"
                    //Si necesitamos agregar alguna apikey o algun parametro en especifico agregamos esto
//                    parameters.append("key", "")
                }
            }
        }
    }
    //Aqui tenemos todo preparado para ser inyectado
    factoryOf(::ApiService)
    //Cada que tengas que devolver un Repository se va a devolver un RepositoryImpl
    factory<Repository> { RepositoryImpl(get()) }
}