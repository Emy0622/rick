package br.senai.sp.jandira.rickandmorty.model

//usou os mesmos nomes que eståo no json, ele vai no objeto procurar o atributo, tem que ser igualzinho
data class Info(
    val count: Int = 0,
    val pages: Int= 0,
    val next: String = "",
    val prev: String = ""
)


