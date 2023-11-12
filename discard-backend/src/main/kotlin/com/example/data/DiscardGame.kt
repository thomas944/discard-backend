package com.example.data

import io.ktor.websocket.*
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.concurrent.ConcurrentHashMap
import com.example.Connection.Connection
import kotlinx.coroutines.flow.update


class DiscardGame {
    private val state = MutableStateFlow(GameState())

    private val playerSockets = ConcurrentHashMap<Char, WebSocketSession>()

    fun connectPlayer(session: DefaultWebSocketSession, playerName: String): String? {
//        val newPlayer = Connection(session, playerName)
        println("Activated!!!!!!!")
        state.update { currentState ->
            val updatedPlayers = currentState.connectedPlayers + playerName
            println("Connected players: $updatedPlayers")
            GameState(connectedPlayers = updatedPlayers)
        }

        return playerName
    }
}

//try {
//                send("You are connected! There are ${connections.count()} users here.")
//                for (frame in incoming) {
//                    frame as? Frame.Text ?: continue
//                    val receivedText = frame.readText()
//                    val textWithUsername = "[${thisConnection.name}]: $receivedText"
//                    connections.forEach {
//                        it.session.send(textWithUsername)
//                    }
//                }
//            } catch (e: Exception) {
//                println(e.localizedMessage)
//            } finally {
//                println("Removing $thisConnection!")
//                connections -= thisConnection
//            }