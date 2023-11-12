package com.example

import com.example.data.DiscardGame
import com.example.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val game = DiscardGame()
    configureSockets()
    configureSerialization()
    configureMonitoring()
    configureRouting(game)
}
