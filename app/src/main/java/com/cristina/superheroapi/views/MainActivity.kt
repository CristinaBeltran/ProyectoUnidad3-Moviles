package com.cristina.superheroapi.views

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cristina.superheroapi.R
import com.cristina.superheroapi.adapters.CharacterAdapter
import com.cristina.superheroapi.models.CharacterID
import com.cristina.superheroapi.viewmodels.MainActivityViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String){
    Glide.with(view)
        .load(url)
        .into(view)
}

class MainActivity : AppCompatActivity() {

    val mainActivityViewModel : MainActivityViewModel by viewModels()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabIndividualCharacter = findViewById<FloatingActionButton>(R.id.floatingActionButton)


        fabIndividualCharacter.setOnClickListener {
            val intent = Intent(this, IndividualCharacterActivity::class.java)
            startActivity(intent)
        }

        val recyclerViewData = findViewById<RecyclerView>(R.id.recyclerViewData)
        val characterAdapter = CharacterAdapter()
        recyclerViewData.layoutManager = LinearLayoutManager(this)
        recyclerViewData.adapter = characterAdapter


        mainActivityViewModel.characterLiveData.observe(this,
            Observer<List<CharacterID>>{
                characterAdapter.addResults(it)
                characterAdapter.notifyDataSetChanged()
            })

        mainActivityViewModel.getCharacter()
    }
}