package com.tezyapps.minimalmvvm.todo.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TodoScreen(
    uiState: TodoUIState,
    onLoad: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when {
            uiState.isLoading -> {
                CircularProgressIndicator()
            }

            uiState.error != null -> {
                Text("Error: ${uiState.error}")
            }

            uiState.todo != null -> {
                Text(uiState.todo.title)
                Text("Completed: ${uiState.todo.completed}")
            }
        }

        Button(onClick = onLoad) {
            Text("Load Todo")
        }
    }
}