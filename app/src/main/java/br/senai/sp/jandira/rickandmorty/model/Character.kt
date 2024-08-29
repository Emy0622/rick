package br.senai.sp.jandira.rickandmorty.model

data class Character(
    val id: Int = 0,
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = "",
    val origin: Origin = Origin(),
    //(pq é um objeto que ja foi criado)
    val location: Location = Location(),
    val image: String = "",
        //episode e uma lista de strings
    val episode: List<String> = listOf<String>(),
    //lista de... (vai estar vazia, mas vai falar que e de string
    val url: String = "",
    val created: String = ""
)
