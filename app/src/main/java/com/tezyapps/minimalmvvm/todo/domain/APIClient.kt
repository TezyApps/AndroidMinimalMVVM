package com.tezyapps.minimalmvvm.todo.domain

import com.tezyapps.minimalmvvm.todo.data.TodoAPI
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object APIClient {

    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val json = Json {
        ignoreUnknownKeys = true
    }

    val todoAPI: TodoAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            json.asConverterFactory(
                "application/json".toMediaType()
            )
        )
        .build()
        .create(TodoAPI::class.java)
}