package com.cristina.superheroapi.models

import com.google.gson.annotations.SerializedName

data class PowerstatsID (
    @SerializedName("response") val response : String,
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("intelligence") val intelligence : Int,
    @SerializedName("strength") val strength : Int,
    @SerializedName("speed") val speed : Int,
    @SerializedName("durability") val durability : Int,
    @SerializedName("power") val power : Int,
    @SerializedName("combat") val combat : Int
)