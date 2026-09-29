package com.tezyapps.minimalmvvm.todo.data

import com.tezyapps.minimalmvvm.todo.domain.Todo
import retrofit2.http.GET

interface TodoAPI {

    @GET("todos/1")
    suspend fun getTodo(): Todo

}