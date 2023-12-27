package com.morayl.composenavigationargs.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.morayl.composenavigationargs.core.model.SearchParameter
import java.time.LocalTime

@Composable
fun SearchParameterScreen(
    onClickDecideParameter: (SearchParameter) -> Unit,
    onClickDecideFloat: (Float) -> Unit,
    onClickClearParameter: () -> Unit,
    viewModel: SearchParameterViewModel = hiltViewModel(),
) {
    Column {
        Button(onClick = { onClickDecideParameter(viewModel.parameter) }) {
            Text(text = "decide parameter")
        }
        Button(onClick = { onClickDecideFloat(LocalTime.now().second.toFloat()) }) {
            Text(text = "decide float")
        }
        Button(onClick = { onClickClearParameter() }) {
            Text(text = "clear parameter")
        }
    }
}