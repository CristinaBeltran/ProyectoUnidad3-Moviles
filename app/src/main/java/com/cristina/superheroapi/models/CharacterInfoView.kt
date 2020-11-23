package com.cristina.superheroapi.models

import com.google.gson.annotations.SerializedName

data class CharacterInfoView (
    var name: String,
    var fullName: String,
    var placeBirth: String,
    var connections: String,
    var intelligence: Int,
    var strength: Int,
    var speed: Int,
    var durability: Int,
    var power: Int,
    var combat: Int
)