package di


import screens.loginScreen.LoginViewModel
import data.ApiServices
import data.DataRepo
import data.onLoginApi
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging

import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.contentType


val dataModule = module {
    single {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                // TODO Fix API so it serves application/json
                json(json, contentType = ContentType.Any)
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("Logger Ktor =>  $message")
                    }
                }
                level = LogLevel.ALL
            }
            install(ResponseObserver) {
                onResponse { response ->
                    println("HTTP status: ${response.status.value}")
                }
            }

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
            }

            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }

    }


    single<ApiServices> { onLoginApi(get()) }

//    single<MuseumApi> { KtorMuseumApi(get()) }
//    single<MuseumStorage> { InMemoryMuseumStorage() }
    single {
        DataRepo(get())
    }
}

val screenModelsModule = module {
   factoryOf(::LoginViewModel)
}



fun initKoin() {
    startKoin {
        modules(
            dataModule,
            screenModelsModule
        )
    }
}
