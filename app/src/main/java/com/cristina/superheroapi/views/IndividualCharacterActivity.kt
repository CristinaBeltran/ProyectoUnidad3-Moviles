package com.cristina.superheroapi.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cristina.superheroapi.R
import com.cristina.superheroapi.adapters.IndividualCharacterAdapter
import com.cristina.superheroapi.viewmodels.IndividualCharacterActivityViewModel
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.cristina.superheroapi.models.CharacterID
import com.cristina.superheroapi.models.Results

@BindingAdapter("image")
fun ImageLoad(view: ImageView, url: String){
    Glide.with(view)
        .load(url)
        .into(view)
}

class IndividualCharacterActivity : AppCompatActivity() {
    val individualCharacterActivityViewModel : IndividualCharacterActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_individual_character)

        val btnCharacter = findViewById<Button>(R.id.btnCharacter)
        val txtName = findViewById<EditText>(R.id.editTextPersonName)
        var name : String ;

        btnCharacter.setOnClickListener {
            val recyclerViewData = findViewById<RecyclerView>(R.id.recyclerViewIndividual)
            recyclerViewData.layoutManager = LinearLayoutManager(this)
            val IndividualCharacterAdapter = IndividualCharacterAdapter()
            recyclerViewData.adapter = IndividualCharacterAdapter
            name = txtName.text.toString()

            individualCharacterActivityViewModel.characterLiveData.observe(this,
                Observer<List<Results>> {
                    IndividualCharacterAdapter.addResults(it)
                    IndividualCharacterAdapter.notifyDataSetChanged()
                })
            individualCharacterActivityViewModel.getCharacter(name)
        }

    }
}