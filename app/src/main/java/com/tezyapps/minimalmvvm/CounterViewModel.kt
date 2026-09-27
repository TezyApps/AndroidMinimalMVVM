package com.tezyapps.minimalmvvm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel: ViewModel() {

    // Mutable property state for reactive binding similar to Combine's @Published
    private val _count = MutableStateFlow(0)

    // private(set) property state
    val count = _count.asStateFlow()

    fun increment() {
        _count.value++
    }

}