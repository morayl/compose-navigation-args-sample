package com.morayl.composenavigationargs.navigation.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.morayl.composenavigationargs.core.ui.navigation.ScreenArgs
import com.morayl.composenavigationargs.core.ui.navigation.args.SearchResultArgs
import com.morayl.composenavigationargs.ext.toNavigationUri
import com.morayl.composenavigationargs.feature.search.SearchResultScreen
import com.morayl.composenavigationargs.toplevel.navScreenArgument

private const val SEARCH_RESULT = "search_result"

fun NavController.toSearchResult(args: SearchResultArgs) {
    navigate(route = "$SEARCH_RESULT/${args.toNavigationUri()}")
}

fun NavGraphBuilder.searchResultScreen() {
    composable(
        route = "$SEARCH_RESULT/{${ScreenArgs.KEY}}",
        arguments = navScreenArgument<SearchResultArgs>(),
    ) {
        SearchResultScreen()
    }
}