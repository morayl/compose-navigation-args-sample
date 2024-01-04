package com.morayl.composenavigationargs.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.morayl.composenavigationargs.core.model.Order
import com.morayl.composenavigationargs.core.model.SearchParameter

@Composable
fun SearchParameterBookmarkScreen(
    onClickDecideParameter: (SearchParameter) -> Unit,
) {
    Column {
        Button(onClick = { onClickDecideParameter(SearchParameter("bookmarked", 1, Order.ASC)) }) {
            Text(text = "decide parameter")
        }
    }
}