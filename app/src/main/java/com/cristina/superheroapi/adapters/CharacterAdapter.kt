package com.cristina.superheroapi.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristina.superheroapi.databinding.CardCharacterBinding
import com.cristina.superheroapi.models.CharacterID
import com.cristina.superheroapi.views.InfoCharacterActivity

class CharacterAdapter() : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){

    private val listCharacters = mutableListOf<CharacterID>()

    fun addResults(data: List<CharacterID>) {
        listCharacters.addAll(data);
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cardBinding = CardCharacterBinding.inflate(layoutInflater, parent, false)
        return CharacterViewHolder(cardBinding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        if (holder is CharacterViewHolder){
            val characterView = listCharacters[position]
            holder.onBind(characterView)

            holder.itemView.setOnClickListener {
                var intent = Intent(it.context,InfoCharacterActivity::class.java)
                intent.putExtra("name",characterView.name)
                it.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    inner class CharacterViewHolder(private val cardCharacterBinding: CardCharacterBinding) : RecyclerView.ViewHolder(cardCharacterBinding.root) {

        fun onBind(characterView: CharacterID) {
            cardCharacterBinding.character = characterView
            cardCharacterBinding.executePendingBindings()

        }
    }
}