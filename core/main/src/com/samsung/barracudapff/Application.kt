package com.samsung.barracudapff

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.samsung.barracudapff.application.v1
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.routing.Routing
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module(testing: Boolean = false) {

    install(ContentNegotiation) {
        gson {
            registerTypeAdapter(LocalDate::class.java, object : TypeAdapter<LocalDate>() {
                val format = DateTimeFormatter.ISO_DATE

                override fun write(out: JsonWriter, value: LocalDate) {
                    out.value(format.format(value))
                }

                override fun read(input: JsonReader): LocalDate = LocalDate.parse(input.nextString(), format)

            })
            if (!testing) {
                setPrettyPrinting()
            }
        }
    }

    install(Routing) {
        v1()
    }
}
