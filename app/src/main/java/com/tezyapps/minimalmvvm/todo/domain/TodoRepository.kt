package com.tezyapps.minimalmvvm.todo.domain

interface TodoRepository {
    suspend fun getTodo(): Todo
}