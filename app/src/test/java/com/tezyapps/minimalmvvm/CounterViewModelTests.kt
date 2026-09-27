package com.tezyapps.minimalmvvm

import org.junit.Assert.assertEquals
import org.junit.Test

class CounterViewModelTests {

    @Test
    fun `initial count is zero`() {
        val viewModel = CounterViewModel(repository = FakeCounterRepository())
        assertEquals(
            0,
            viewModel.uiState.value.count
        )
    }

    @Test
    fun `increment increases count by one`() {
        val viewModel = CounterViewModel(repository = FakeCounterRepository())

        viewModel.onAction(CounterAction.Increment)
        assertEquals(
            1,
            viewModel.uiState.value.count
        )
    }

    @Test
    fun `decrement decreases count by one`() {
        val viewModel = CounterViewModel(repository = FakeCounterRepository())
        viewModel.onAction(CounterAction.Decrement)
        assertEquals(
            -1,
            viewModel.uiState.value.count
        )
    }

    @Test
    fun `reset sets count to zero`() {
        val viewModel = CounterViewModel(repository = FakeCounterRepository())
        viewModel.onAction(CounterAction.Increment)
        viewModel.onAction(CounterAction.Increment)
        viewModel.onAction(CounterAction.Increment)
        val afterThreeIncrements = viewModel.uiState.value.count

        viewModel.onAction(CounterAction.Reset)
        assertEquals(3, afterThreeIncrements)
        assertEquals(
            0,
            viewModel.uiState.value.count
        )
    }
}