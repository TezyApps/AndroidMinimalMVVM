package com.tezyapps.minimalmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tezyapps.minimalmvvm.counter.data.FakeCounterRepository
import com.tezyapps.minimalmvvm.counter.domain.CounterViewModelFactory
import com.tezyapps.minimalmvvm.counter.ui.CounterScreen
import com.tezyapps.minimalmvvm.counter.ui.CounterViewModel

class MainActivity : ComponentActivity() {

    private val repository = FakeCounterRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val factory = CounterViewModelFactory(repository)
            val viewModel: CounterViewModel = viewModel(factory = factory)
            CounterRoute(viewModel = viewModel)
        }
    }
}

@Composable
fun CounterRoute(viewModel: CounterViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    CounterScreen(
        uiState = uiState,
        onAction = viewModel::onAction
    )
}