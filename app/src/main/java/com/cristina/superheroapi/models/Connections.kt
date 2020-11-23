package com.cristina.superheroapi.models

import com.google.gson.annotations.SerializedName

data class Connections (
    @SerializedName("group-affiliation") val group_affiliation : String,
    @SerializedName("relatives") val relatives : String
)