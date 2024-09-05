package br.senai.sp.jandira.rickandmorty.service
import br.senai.sp.jandira.rickandmorty.model.Character
import br.senai.sp.jandira.rickandmorty.model.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//essa função vai entregar // buscar 1 personagem pelo id
interface CharacterService {
    @GET("character/{id}")
    //o valor colocado nesse id vai ser mandando para o path
    fun getCharacterById(@Path("id") id: Int): Call<Character>
    // ta informando que vai pegar o id e jogar no path no lugar do template que tem esse id aqui

    //tipo de requisicao - qual endpoint
    @GET("character")
    //criar funcao
    fun getAllCharacters(): Call<Results>

    //criar um objeto que representa a lista de personagens tipo o results, characrer
}
