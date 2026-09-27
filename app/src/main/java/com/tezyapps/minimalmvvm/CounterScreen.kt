package com.tezyapps.minimalmvvm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CounterScreen(
    uiState: CounterUIState,
    onAction: (CounterAction) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (uiState.isLoading) {
            CircularProgressIndicator()
        } else {
            Text("Count : ${uiState.count}")
        }

        Button(onClick = { onAction(CounterAction.Load) }) {
            Text("Load")
        }

        Button(
            {
                onAction(CounterAction.Increment)
            }
        ) {
            Text("Increment")
        }

        Button(
            {
                onAction(CounterAction.Decrement)
            }
        ) {
            Text("Decrement")
        }

        Button(
            {
                onAction(CounterAction.Reset)
            }
        ) {
            Text("Reset")
        }
    }
}