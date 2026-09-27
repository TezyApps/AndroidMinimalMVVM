package com.tezyapps.minimalmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tezyapps.minimalmvvm.ui.theme.MinimalMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterRoute(viewModel = CounterViewModel())
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