package com.tezyapps.minimalmvvm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel: ViewModel() {

    // Mutable property state for reactive binding similar to Combine's @Published
    private val _uiState = MutableStateFlow(CounterUIState())

    // private(set) property state
    val uiState = _uiState.asStateFlow()

    fun onAction(action: CounterAction) {
        when (action) {
            CounterAction.Increment -> increment()
            CounterAction.Decrement -> decrement()
            CounterAction.Reset -> reset()
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