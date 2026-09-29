package com.tezyapps.minimalmvvm.todo.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tezyapps.minimalmvvm.todo.presentation.TodoViewModel

class TodoViewModelFactory(
    private val repository: TodoRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TodoViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel of class ${modelClass.name}"
        )
    }
}