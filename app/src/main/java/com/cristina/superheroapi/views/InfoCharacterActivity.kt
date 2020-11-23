package com.cristina.superheroapi.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.cristina.superheroapi.R
import com.cristina.superheroapi.databinding.ActivityInfoCharacterBinding
import com.cristina.superheroapi.models.Results
import com.cristina.superheroapi.viewmodels.InfoCharacterActivityViewModel

class InfoCharacterActivity : AppCompatActivity() {

     private val infoCharacterActivityViewModel : InfoCharacterActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityInfoCharacterBinding = DataBindingUtil.setContentView(this,R.layout.activity_info_character)
        val name = intent.extras?.getString("name")

        infoCharacterActivityViewModel.characterLiveData.observe(this,
        Observer<List<Results>>{character ->
            binding.character = character[0]
            binding.executePendingBindings()
        })
        infoCharacterActivityViewModel.getCharacter(name!!)
    }
}