package com.morayl.composenavigationargs.ext

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.morayl.composenavigationargs.navigation.graph.NavigationGraph

internal fun NavGraphBuilder.navigation(graph: NavigationGraph, startDestination: String, builder: NavGraphBuilder.() -> Unit) {
    navigation(route = graph.value, startDestination = startDestination, builder = builder)
}