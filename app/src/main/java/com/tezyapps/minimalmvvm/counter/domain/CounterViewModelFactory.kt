package com.tezyapps.minimalmvvm.counter.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tezyapps.minimalmvvm.counter.ui.CounterViewModel

class CounterViewModelFactory(
    private val repository: CounterRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CounterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CounterViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class: ${modelClass.name}"
        )
    }
}