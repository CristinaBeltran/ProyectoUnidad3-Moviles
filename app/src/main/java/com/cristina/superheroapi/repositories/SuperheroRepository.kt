package com.cristina.superheroapi.repositories

import com.cristina.superheroapi.models.*
import com.cristina.superheroapi.net.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class SuperheroRepository {

    suspend fun getCharacter(id: Int) = suspendCoroutine<CharacterID> {
        RetrofitInstance.superheroService.getCharacter(id).enqueue(
            object: Callback<CharacterID> {
                override fun onResponse(call: Call<CharacterID>, response: Response<CharacterID>) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<CharacterID>, t: Throwable) {
                    it.resumeWithException(t)
                }

            }
        )
    }
    suspend fun getCharacterByName(name: String) = suspendCoroutine<CharacterName> {
        RetrofitInstance.superheroService.getCharacterByName(name).enqueue(
            object: Callback<CharacterName> {
                override fun onResponse(call: Call<CharacterName>, response: Response<CharacterName>) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<CharacterName>, t: Throwable) {
                    it.resumeWithException(t)
                }

            }
        )
    }
    suspend fun getCharacterBiography(id: Int) = suspendCoroutine<BiographyID> {
        RetrofitInstance.superheroService.getBiography(id).enqueue(
            object: Callback<BiographyID> {
                override fun onResponse(call: Call<BiographyID>, response: Response<BiographyID>) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<BiographyID>, t: Throwable) {
                    it.resumeWithException(t)
                }

            }
        )
    }
    suspend fun getCharacterPowers(id: Int) = suspendCoroutine<PowerstatsID> {
        RetrofitInstance.superheroService.getPowerstats(id).enqueue(
            object: Callback<PowerstatsID> {
                override fun onResponse(call: Call<PowerstatsID>, response: Response<PowerstatsID>) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<PowerstatsID>, t: Throwable) {
                    it.resumeWithException(t)
                }

            }
        )
    }

    suspend fun getCharacterConnections(id: Int) = suspendCoroutine<ConnectionsID> {
        RetrofitInstance.superheroService.getConnections(id).enqueue(
            object: Callback<ConnectionsID> {
                override fun onResponse(call: Call<ConnectionsID>, response: Response<ConnectionsID>) {
                    it.resume(response.body()!!)
                }

                override fun onFailure(call: Call<ConnectionsID>, t: Throwable) {
                    it.resumeWithException(t)
                }

            }
        )
    }
}