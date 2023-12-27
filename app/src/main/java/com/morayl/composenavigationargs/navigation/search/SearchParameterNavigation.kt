package com.morayl.composenavigationargs.navigation.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.morayl.composenavigationargs.core.ui.constant.ScreenResultKey
import com.morayl.composenavigationargs.core.ui.ext.setScreenResult
import com.morayl.composenavigationargs.core.ui.ext.setUnitScreenResult
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
                navController.previousBackStackEntry?.setScreenResult(ScreenResultKey.SEARCH_PARAMETER, it)
                navController.popBackStack()
            },
            onClickDecideFloat = {
                navController.previousBackStackEntry?.setScreenResult(ScreenResultKey.SEARCH_FLOAT, it)
                navController.popBackStack()
            },
            onClickClearParameter = {
                navController.previousBackStackEntry?.setUnitScreenResult(ScreenResultKey.SEARCH_FLOAT)
                navController.popBackStack()
            },
        )
    }
}