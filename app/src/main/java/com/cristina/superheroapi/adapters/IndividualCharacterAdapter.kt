package com.cristina.superheroapi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cristina.superheroapi.databinding.CardCharacterBinding
import com.cristina.superheroapi.databinding.CardIndividualCharacterBinding
import com.cristina.superheroapi.models.CharacterID
import com.cristina.superheroapi.models.CharacterName
import com.cristina.superheroapi.models.Results

class IndividualCharacterAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listCharacter = mutableListOf<Results>()

    fun addResults(data: List<Results>) {
        listCharacter.addAll(data);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cardBinding = CardIndividualCharacterBinding.inflate(layoutInflater,parent,false)
        return CharacterViewHolder(cardBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CharacterViewHolder){
            val characterView = listCharacter[position]
            holder.onBind(characterView)
        }
    }

    override fun getItemCount(): Int {
        return listCharacter.size
    }

    inner class CharacterViewHolder(private val cardIndividualCharacterBinding: CardIndividualCharacterBinding) : RecyclerView.ViewHolder(cardIndividualCharacterBinding.root){

        fun onBind(characterView: Results) {
            cardIndividualCharacterBinding.character = characterView
            cardIndividualCharacterBinding.executePendingBindings()
        }
    }
}