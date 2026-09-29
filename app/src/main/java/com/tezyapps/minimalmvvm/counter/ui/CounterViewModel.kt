package com.tezyapps.minimalmvvm.counter.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tezyapps.minimalmvvm.counter.domain.CounterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CounterViewModel(
    private val repository: CounterRepository
): ViewModel() {

    // Mutable property state for reactive binding similar to Combine's @Published
    private val _uiState = MutableStateFlow(CounterUIState())

    // private(set) property state
    val uiState = _uiState.asStateFlow()

    fun onAction(action: CounterAction) {
        when (action) {
            CounterAction.Load -> load()
            CounterAction.Increment -> increment()
            CounterAction.Decrement -> decrement()
            CounterAction.Reset -> reset()
        }
    }

    private fun load() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }

            val count = repository.getCount()

            _uiState.update {
                it.copy(count = count, isLoading = false)
            }
        }
    }

    private fun increment() {
        _uiState.update { currentState ->
            currentState.copy(
                count = currentState.count + 1
            )
        }
    }

    private fun decrement() {
        _uiState.update { currentState ->
            currentState.copy(
                count = currentState.count - 1
            )
        }
    }

    private fun reset() {
        _uiState.update { currentState ->
            currentState.copy(count = 0)
        }
    }

}