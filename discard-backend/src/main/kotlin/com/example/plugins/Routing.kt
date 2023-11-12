package com.example.plugins

import com.example.data.DiscardGame
import com.example.socket
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(game: DiscardGame) {
    routing {
        socket(game)
//        get("/") {
//            call.respondText("Hello World!")
//        }
    }
}
