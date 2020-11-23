package com.cristina.superheroapi.models

import com.google.gson.annotations.SerializedName

data class CharacterName(
    @SerializedName("response") val response : String,
    @SerializedName("results-for") val results_for : String,
    @SerializedName("results") val results : List<Results>
)