package com.morayl.composenavigationargs.navigation.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.morayl.composenavigationargs.core.ui.constant.ScreenResultKey
import com.morayl.composenavigationargs.core.ui.ext.setScreenResultAndPopBack
import com.morayl.composenavigationargs.core.ui.ext.setUnitScreenResultAndPopBack
import com.morayl.composenavigationargs.feature.search.SearchParameterScreen

private const val SEARCH_PARAMETER = "search_parameter"

fun NavController.toSearchParameter() {
    navigate(route = SEARCH_PARAMETER)
}

fun NavGraphBuilder.searchParameterScreen(
    navController: NavController,
) {
    composable(route = SEARCH_PARAMETER) {
        SearchParameterScreen(
            onClickDecideParameter = {
                navController.setScreenResultAndPopBack(ScreenResultKey.SEARCH_PARAMETER, it)
            },
            onClickDecideFloat = {
                navController.setScreenResultAndPopBack(ScreenResultKey.SEARCH_FLOAT, it)
            },
            onClickClearParameter = {
                navController.setUnitScreenResultAndPopBack(ScreenResultKey.SEARCH_CLEAR)
            },
            onClickToBookmark = {
                navController.toSearchParameterBookmark()
            },
        )
    }
}