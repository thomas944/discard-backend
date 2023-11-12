package com.example

import com.example.data.DiscardGame
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*

fun Route.socket(game: DiscardGame){
    route("/play/{playerName}"){
        webSocket {
            val playerName = call.parameters["playerName"]
            if (playerName != null) {
                println("Adding new user: $playerName")
                val player = game.connectPlayer(this@webSocket, playerName)

                try {
                    for (frame in incoming) {
                        when (frame) {
                            is Frame.Text -> {
                                val text = frame.readText()
                                println("Received message from $playerName: $text")
                            }
                            else -> {
                                println("Received unsupported frame type from $playerName")

                            }

                        }

                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    println("WebSocket session closed for $playerName")

                }


            }
            else {
                close(CloseReason(CloseReason.Codes.VIOLATED_POLICY, "Player name is required."))
            }
        }

    }
}

//        param("playerName") { playerName ->
//            webSocket {
//                println("Adding new user: $playerName")
//                val player = game.connectPlayer(this, playerName)
//                // Rest of your WebSocket handling logic
//            }

//            try {
//                send("You are connected!")
//                for (frame in incoming) {
//                    frame as? Frame.Text ?: continue
//                    val receivedText = frame.readText()
//                    val textWithUsername = "[${thisConnection.name}]: $receivedText"
//                    connections.forEach {
//                        it.session.send(textWithUsername)
//                    }
//                }
//
//            }


//    }
//}

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