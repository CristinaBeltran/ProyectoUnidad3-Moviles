package com.cristina.superheroapi.models

import com.google.gson.annotations.SerializedName

data class ConnectionsID (
    @SerializedName("response") val response : String,
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("group-affiliation") val group_affiliation : String,
    @SerializedName("relatives") val relatives : String
)