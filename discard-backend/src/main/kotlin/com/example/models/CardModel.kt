package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class CardModel(val suit: String, val rank: String){
    val cardId: String
        get() = "$suit-$rank"
}
