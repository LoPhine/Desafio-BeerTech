package com.example.desafiobeertech.network

import com.squareup.moshi.Json

data class Beers (
    @Json(name = "produto")
    val product: String,

    @Json(name = "descricao")
    val description: String,

    @Json(name = "preco")
    val price: Double,

    @Json(name = "desconto")
    val discount: Boolean,

    @Json(name = "imagem")
    val image: String
)