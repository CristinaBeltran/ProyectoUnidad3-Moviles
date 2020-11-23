package com.cristina.superheroapi.net.services

import com.cristina.superheroapi.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroService{

    @GET("{id}")
    fun getCharacter(@Path("id")id: Int) : Call<CharacterID>

    @GET("search/{name}")
    fun getCharacterByName(@Path("name")name: String) : Call<CharacterName>

    @GET("{id}/biography")
    fun getBiography(@Path("id")id: Int) : Call<BiographyID>

    @GET("{id}/powerstats")
    fun getPowerstats(@Path("id")id: Int) : Call<PowerstatsID>

    @GET("{id}/connections")
    fun getConnections(@Path("id")id: Int) : Call<ConnectionsID>
}