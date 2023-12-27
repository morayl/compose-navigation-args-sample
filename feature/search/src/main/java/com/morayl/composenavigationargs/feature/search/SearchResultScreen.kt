package com.morayl.composenavigationargs.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SearchResultScreen(
    viewModel: SearchResultViewModel = hiltViewModel(),
) {
    Column {
        Text(text = viewModel.screenArgs.toString(), color = Color.Yellow)
    }
}