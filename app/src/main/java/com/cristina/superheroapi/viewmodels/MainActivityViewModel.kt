package com.cristina.superheroapi.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.cristina.superheroapi.models.CharacterID
import com.cristina.superheroapi.repositories.SuperheroRepository
import kotlinx.coroutines.launch

class MainActivityViewModel(application : Application) : AndroidViewModel(application){
    private val superheroRepository = SuperheroRepository();
    val characterLiveData = MutableLiveData<List<CharacterID>>();
    private val list= mutableListOf<CharacterID>()

    fun getCharacter() {
        viewModelScope.launch {
            for(id in 1..8){
                val character=superheroRepository.getCharacter(id)
                list.add(character)
            }
            characterLiveData.postValue(list)
        }
    }
}