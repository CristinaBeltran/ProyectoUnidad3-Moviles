package com.cristina.superheroapi.models

import com.google.gson.annotations.SerializedName

data class Work (
    @SerializedName("occupation") val gender : String,
    @SerializedName("base") val race : String
)