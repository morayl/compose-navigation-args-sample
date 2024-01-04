package com.morayl.composenavigationargs.navigation.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.morayl.composenavigationargs.core.ui.constant.ScreenResultKey
import com.morayl.composenavigationargs.core.ui.ext.setScreenResultAndPopBack
import com.morayl.composenavigationargs.feature.search.SearchParameterBookmarkScreen

private const val SEARCH_PARAMETER_BOOKMARK = "search_parameter_bookmark"

fun NavController.toSearchParameterBookmark() {
    navigate(route = SEARCH_PARAMETER_BOOKMARK)
}

fun NavGraphBuilder.searchParameterBookmarkScreen(
    navController: NavController,
) {
    composable(route = SEARCH_PARAMETER_BOOKMARK) {
        SearchParameterBookmarkScreen(
            onClickDecideParameter = {
                navController.setScreenResultAndPopBack(ScreenResultKey.SEARCH_PARAMETER, it, SEARCH_TOP)
            },
        )
    }
}