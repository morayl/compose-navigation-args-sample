package com.morayl.composenavigationargs.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import com.morayl.composenavigationargs.core.model.SearchParameter
import com.morayl.composenavigationargs.core.ui.constant.ScreenResultKey
import com.morayl.composenavigationargs.core.ui.ext.consumeScreenResult

@Composable
fun SearchTopScreen(
    backStackEntry: NavBackStackEntry,
    onClickSelectParameter: () -> Unit,
    viewModel: SearchTopViewModel = hiltViewModel(),
) {
    val parameterStr by viewModel.parameterFlow.collectAsStateWithLifecycle()
    backStackEntry.consumeScreenResult<SearchParameter>(ScreenResultKey.SEARCH_PARAMETER) {
        viewModel.updateParameter(it)
    }
    Column {
        Text(text = parameterStr, color = Color.Red)
        Button(onClick = onClickSelectParameter) {
            Text(text = "Go to select parameter page")
        }
    }
}