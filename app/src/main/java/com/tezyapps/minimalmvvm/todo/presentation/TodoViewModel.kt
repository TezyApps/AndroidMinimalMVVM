package com.tezyapps.minimalmvvm.todo.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tezyapps.minimalmvvm.todo.presentation.TodoUIState
import com.tezyapps.minimalmvvm.todo.domain.Todo
import com.tezyapps.minimalmvvm.todo.domain.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TodoViewModel(
    val repository: TodoRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(TodoUIState())
    val uiState = _uiState.asStateFlow()

    fun loadTodo() {
        viewModelScope.launch {
            updateState(isLoading = true)

            try {
                val todo = repository.getTodo()
                updateState(todo = todo, isLoading = false)
            } catch (exception: Exception) {
                updateState(isLoading = false, error = exception.message)
            }

        }
    }

    private fun updateState(todo: Todo? = null, isLoading: Boolean = false, error: String? = null) {
        _uiState.update {
            it.copy(todo = todo, isLoading = isLoading, error = error)
        }
    }
}