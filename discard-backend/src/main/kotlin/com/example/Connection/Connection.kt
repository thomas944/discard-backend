package com.example.Connection

import io.ktor.websocket.*
import java.util.concurrent.atomic.AtomicInteger

class Connection(val session: DefaultWebSocketSession, val playerName: String) {
    companion object {
        val lastId = AtomicInteger(0)
    }
//    val name = "user${lastId.getAndIncrement()}"
    val name = "$playerName"
}