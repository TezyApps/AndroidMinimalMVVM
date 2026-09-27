package com.tezyapps.minimalmvvm

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun CounterScreen(viewModel: CounterViewModel) {

    val count by viewModel.count.collectAsState()

    Column {
        Text("Count: $count")
    }
}