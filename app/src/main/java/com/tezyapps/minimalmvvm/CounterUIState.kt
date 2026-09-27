package com.tezyapps.minimalmvvm

data class CounterUIState(
    val count: Int = 0,
    var isLoading: Boolean = false
)