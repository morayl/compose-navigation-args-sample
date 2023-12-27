package com.morayl.composenavigationargs.feature.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import com.morayl.composenavigationargs.core.model.SearchParameter
import com.morayl.composenavigationargs.core.ui.constant.ScreenResultKey
import com.morayl.composenavigationargs.core.ui.ext.consumeScreenResult
import com.morayl.composenavigationargs.core.ui.ext.consumeUnitScreenResult

@Composable
fun SearchTopScreen(
    backStackEntry: NavBackStackEntry,
    onClickSelectParameter: () -> Unit,
    viewModel: SearchTopViewModel = hiltViewModel(),
) {
    val parameterStr by viewModel.parameterFlow.collectAsStateWithLifecycle()
    val floatStr by viewModel.floatValueFlow.collectAsStateWithLifecycle()
    backStackEntry.consumeScreenResult<SearchParameter>(ScreenResultKey.SEARCH_PARAMETER) {
        viewModel.updateParameter(it)
    }
    backStackEntry.consumeScreenResult<Float>(ScreenResultKey.SEARCH_FLOAT) {
        viewModel.updateFloat(it)
    }
    backStackEntry.consumeUnitScreenResult(ScreenResultKey.SEARCH_CLEAR) {
        viewModel.clearResults()
    }
    Column(verticalArrangement = Arrangement.Center) {
        Text(text = parameterStr, color = Color.Red)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = floatStr, color = Color.Red)
        Button(onClick = onClickSelectParameter) {
            Text(text = "Go to select parameter page")
        }
    }
}
