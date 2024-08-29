package br.senai.sp.jandira.rickandmorty.service

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//classe responsavel por chegar no servidor

class RetrofitFactory {
    private val BASE_URL = "https://rickandmortyapi.com/api/"
            //url base

    private val retrofitFactory = Retrofit
    //retroFac e tipo um post, faz a conexao, retrofir sabe pra onde vai fazer a requisicao
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //retomar o character service
    //criar o quesito de requisicao
    fun getCharacterService(): CharacterService{
        return retrofitFactory.create(CharacterService::class.java)
    }

}

//(PARA CONSUMIR A API NO ANDROID)

//Vai mudar a url base, no service nn vai ser caracter, vai ser o nome dos objetos que temos, e provavelmente vms ter varias requisicoes