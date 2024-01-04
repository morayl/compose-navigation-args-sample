package com.morayl.composenavigationargs.navigation.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.morayl.composenavigationargs.ext.navigation
import com.morayl.composenavigationargs.feature.search.SearchTopScreen
import com.morayl.composenavigationargs.navigation.graph.NavigationGraph

const val SEARCH_TOP = "search_top"

fun NavController.toSearchTop() {
    navigate(route = SEARCH_TOP)
}

fun NavGraphBuilder.searchGraph(
    navController: NavController,
    nestedGraph: NavGraphBuilder.() -> Unit,
) {
    navigation(graph = NavigationGraph.SEARCH, startDestination = SEARCH_TOP) {
        composable(route = SEARCH_TOP) {
            SearchTopScreen(
                it,
                onClickSelectParameter = { navController.toSearchParameter() },
                onClickToResult = { navController.toSearchResult(it) },
            )
        }
    }
    nestedGraph()
}