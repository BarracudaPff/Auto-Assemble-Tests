package com.samsung.barracudapff.application.actions

import io.ktor.application.ApplicationCall
import io.ktor.response.respond
import java.io.File
import java.io.FileInputStream
import java.util.*

suspend fun ApplicationCall.v1Info() {
    respond(mapOf("info" to getInfo()))
}

private fun getInfo(): String {
    val props = Properties()
    props.load(FileInputStream("gradle.properties"))

    return props["version"] as String
}
