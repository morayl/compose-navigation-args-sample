package com.morayl.composenavigationargs.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SearchTopScreen(
    onClickSelectParameter: () -> Unit,
    viewModel: SearchTopViewModel = hiltViewModel(),
) {
    Column {
        Text(text = viewModel.message, color = Color.Red)
        Button(onClick = onClickSelectParameter) {
            Text(text = "Go to select parameter page")
        }
    }
}