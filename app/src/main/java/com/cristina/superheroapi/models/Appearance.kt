package com.cristina.superheroapi.models

import com.google.gson.annotations.SerializedName

data class Appearance (
    @SerializedName("gender") val gender : String,
    @SerializedName("race") val race : String,
    @SerializedName("height") val height : List<String>,
    @SerializedName("weight") val weight : List<String>,
    @SerializedName("eye_color") val eye_color : String,
    @SerializedName("hair_color") val hair_color : String
)