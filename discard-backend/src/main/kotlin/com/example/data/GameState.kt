package com.example.data

import com.example.models.CardModel
import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
data class GameState(
    val gameOver: Boolean = false,
    val playerRankings: Map<String, Int> = emptyMap(),
    val connectedPlayers: List<String> = emptyList(),
    val playerAtTurn: String? = null,
    //val playerDecks: Map<String, List<String>> = emptyMap(),
    val playerDeck: List<CardModel> = emptyList(),
    val playedCardsPile: List<CardModel> = emptyList(),
    val currentCard: CardModel? = null,
    val deck: List<CardModel> = initialGameState()

) {
    companion object {
        fun initialGameState(): List<CardModel> {
            val initialDeck = allCards
            return initialDeck.shuffled(Random)
        }
    }

}

