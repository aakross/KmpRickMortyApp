package org.example.rickmortyapp.di

import org.koin.core.module.Module
import org.koin.dsl.module

//Se creo este modulo especifico para ios si se desea inyectar cosas especificas para android y otras para ios por separado
actual fun platformModule(): Module {
    return module {

    }
}