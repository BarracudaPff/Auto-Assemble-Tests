package com.samsung.barracudapff.application

import com.samsung.barracudapff.application.actions.v1Info
import com.samsung.barracudapff.application.actions.v1Tests
import io.ktor.application.call
import io.ktor.locations.post
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

fun Routing.v1() {
    v1Info()
    v1AssembleTests()
}

fun Routing.v1AssembleTests() {

}

private fun Routing.v1Info() {

    route("v1") {
        get("info") {
            call.v1Info()
        }
        post("tests/{id}") {
            val parameters = call.parameters
            call.v1Tests(parameters["id"]!!)
        }
    }
}
