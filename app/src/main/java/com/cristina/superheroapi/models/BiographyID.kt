package com.cristina.superheroapi.models

import com.google.gson.annotations.SerializedName

data class BiographyID(
    @SerializedName("response") val response : String,
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("full-name") val full_name : String,
    @SerializedName("alter-egos") val alter_egos : String,
    @SerializedName("aliases") val aliases : List<String>,
    @SerializedName("place-of-birth") val place_of_birth : String,
    @SerializedName("first-appearance") val first_appearance : String,
    @SerializedName("publisher") val publisher : String,
    @SerializedName("alignment") val alignment : String
)