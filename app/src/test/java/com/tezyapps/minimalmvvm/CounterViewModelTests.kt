package com.tezyapps.minimalmvvm

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Rule
import org.junit.Test

class CounterViewModelTests {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

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

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `load updates count from repository`() = runTest {
        val repo = SpyCounterRepository(count = 10)
        val viewModel = CounterViewModel(repo)

        viewModel.onAction(CounterAction.Load)

        advanceUntilIdle()

        assertEquals(10, viewModel.uiState.value.count)

        assertFalse(viewModel.uiState.value.isLoading)
    }

}

// Spy Repository

private class SpyCounterRepository(
    private val count: Int
): CounterRepository {
    override suspend fun getCount(): Int {
        return count
    }
}