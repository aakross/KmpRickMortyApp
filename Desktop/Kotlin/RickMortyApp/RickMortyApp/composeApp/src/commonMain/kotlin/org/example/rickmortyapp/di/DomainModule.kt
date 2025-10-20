package org.example.rickmortyapp.di

import org.example.rickmortyapp.domain.GetRandomCharacter
import org.example.rickmortyapp.domain.core.GetName
import org.example.rickmortyapp.domain.core.NameOperator
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
//Aqui decimos que clase queremos inyectar y aqui en el dominio la declaramos y devuelve un NameOperator en este caso
//    factory<NameOperator> { NameOperator() }
//    Este es con el singleton
    //    single<NameOperator> { NameOperator() }
    //Aqui se le agrego el get porque GetName quiere un nameOperator, lo que hace koin en automatico es buscar aqui y como aqui si existe NameOperator lo busca y lo toma
//    factory<GetName> { GetName(get(), get()) }
    //Factoryof es otra forma de declarar la clase que queremos inyectar
//    factoryOf(::GetName)
    factoryOf(::GetRandomCharacter)
}