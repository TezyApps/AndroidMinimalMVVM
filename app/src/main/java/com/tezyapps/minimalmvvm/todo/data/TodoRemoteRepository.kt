package com.tezyapps.minimalmvvm.todo.data

import com.tezyapps.minimalmvvm.todo.domain.Todo
import com.tezyapps.minimalmvvm.todo.domain.TodoRepository

class TodoRemoteRepository(private val api: TodoAPI): TodoRepository {

    override suspend fun getTodo(): Todo {
        return api.getTodo()
    }

}