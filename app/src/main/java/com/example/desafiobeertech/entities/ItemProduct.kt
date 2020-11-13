package com.example.desafiobeertech.entities

import com.squareup.moshi.Json

data class ItemProduct(
        val product: String,
        val description: String,
        val price: Double,
        val discount: Boolean,
        val image: String
)