package com.morayl.composenavigationargs.feature.search

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SearchTopScreen(
    viewModel: SearchTopViewModel = hiltViewModel(),
) {
    Text(text = viewModel.message, color = Color.Red)
}