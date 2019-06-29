package com.samsung.barracudapff.application.actions

import com.samsung.barracudapff.application.models.Test
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import java.io.File

suspend fun ApplicationCall.v1Tests(id: String) {
    val test = receive<Test>()
    try {
        test.testId = id.toInt()
        if (test.date == null || test.sourceCode == null || test.clientId == null) {
            throw NullPointerException()
        }

        exec(test)
    } catch (e: NumberFormatException) {
        respond(HttpStatusCode.BadRequest, "Id not number")
    } catch (e: NullPointerException) {
        respond(HttpStatusCode.BadRequest, "Wrong POST body")
    }
}

fun exec(test: Test) {
    println(test)
    val file = File("./src/main/java/TestId${test.testId}.java")
    file.writeText(test.sourceCode!!)
    file.createNewFile()
}
