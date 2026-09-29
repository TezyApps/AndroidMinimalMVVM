package com.tezyapps.minimalmvvm.counter.ui

data class CounterUIState(
    val count: Int = 0,
    var isLoading: Boolean = false
)