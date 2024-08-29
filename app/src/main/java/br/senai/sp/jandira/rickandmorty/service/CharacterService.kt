package br.senai.sp.jandira.rickandmorty.service

import br.senai.sp.jandira.rickandmorty.model.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//essa função vai entregar
interface CharacterService {
    @GET("character/{id}")
    //o valor colocado nesse id vai ser mandando para o path
    fun getCharacterById(@Path("id") id: Int): Call<Character>
    // ta informando que vai pegar o id e jogar no path no lugar do template que tem esse id aqui

}