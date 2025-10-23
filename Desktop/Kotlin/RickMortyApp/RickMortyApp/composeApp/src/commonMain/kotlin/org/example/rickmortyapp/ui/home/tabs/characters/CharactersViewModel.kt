package org.example.rickmortyapp.ui.home.tabs.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.example.rickmortyapp.domain.GetRandomCharacter
import org.example.rickmortyapp.domain.Repository
import org.example.rickmortyapp.domain.model.CharacterModel

class CharactersViewModel(
    val getRandomCharacter: GetRandomCharacter,
    private val repository: Repository
) :
    ViewModel() {
    //Aqui le estamos diciendo al viewmodel que queremos tener nuestro estado que es puede mutar lo queremos privado ya que no queremos que desde la screen o vista nos modifiquen el valor que ya tiene
    //Entonces el viewModel es el unico que lo puede modificar y ahi es donde entra el val state ya que desde ahi solo podremos leer y no permite modificar el estado porque es stateflow no un mutablestateflow
    private val _state = MutableStateFlow<CharactersState>(CharactersState())
    val state: StateFlow<CharactersState> = _state

    //El metodo init sirve para inicializarlo cuando se mande a llamar al viewModel es como un useEffect en react con el [] vacio
    init {
        viewModelScope.launch {
            val result: CharacterModel = withContext(Dispatchers.IO) {
                getRandomCharacter()
            }
            _state.update { state -> state.copy(characterOfTheDay = result) }
        }
        getAllCharacters()
    }

    private fun getAllCharacters() {
        _state.update { state ->
            state.copy(
                characters = repository.getAllCharacters()
            )
        }
    }
}