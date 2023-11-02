package com.valllent.shared.logic.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.set
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object Client {

    private val client: HttpClient = HttpClient {
        defaultRequest {
            url.set {
                host = "api.artic.edu"
            }
        }

        install(ContentNegotiation) {
            json(
                Json {
                    isLenient = true;
                    ignoreUnknownKeys = true
                }
            )
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.NONE
        }
    }

    fun get(): HttpClient {
        return client
    }

}