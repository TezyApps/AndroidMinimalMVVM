package com.tezyapps.minimalmvvm.todo.presentation

import com.tezyapps.minimalmvvm.todo.domain.Todo

data class TodoUIState(
    val todo: Todo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)