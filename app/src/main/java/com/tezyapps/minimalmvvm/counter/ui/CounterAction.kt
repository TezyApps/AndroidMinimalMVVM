package com.tezyapps.minimalmvvm.counter.ui

sealed interface CounterAction {
    data object Load: CounterAction
    data object Increment: CounterAction
    data object Decrement: CounterAction
    data object Reset: CounterAction
}