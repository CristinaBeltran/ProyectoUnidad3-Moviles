package com.cristina.superheroapi.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cristina.superheroapi.models.CharacterID
import com.cristina.superheroapi.models.CharacterName
import com.cristina.superheroapi.models.Results
import com.cristina.superheroapi.repositories.SuperheroRepository
import kotlinx.coroutines.launch

class IndividualCharacterActivityViewModel (application : Application) : AndroidViewModel(application){
    private val superheroRepository = SuperheroRepository();
    val characterLiveData = MutableLiveData<List<Results>>();

    fun getCharacter(name : String) {
        viewModelScope.launch {
            val characterName = superheroRepository.getCharacterByName(name)
            val listCharactersView = characterName.results.map { result ->
                Results(
                    result.id,
                    result.name,
                    result.powerstats,
                    result.biography,
                    result.appearance,
                    result.origin,
                    result.connections,
                    result.image
                )
            }
            characterLiveData.postValue(listCharactersView)
        }
    }
}