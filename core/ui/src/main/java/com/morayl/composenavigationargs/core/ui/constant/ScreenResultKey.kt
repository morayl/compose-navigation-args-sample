package com.morayl.composenavigationargs.core.ui.constant

import com.morayl.composenavigationargs.core.model.SearchParameter
import com.morayl.composenavigationargs.core.ui.ext.ParcelableUnit

sealed interface ScreenResultKey<T> {
    data object SelectedSearchParameter : ScreenResultKey<SearchParameter>
    data object SelectedSearchFloat : ScreenResultKey<Float>
    data object SelectedSearchClear : ScreenResultKey<ParcelableUnit>
}

internal val ScreenResultKey<*>.value: String
    get() = when (this) {
        is ScreenResultKey.SelectedSearchParameter -> "selected_search_parameter"
        is ScreenResultKey.SelectedSearchFloat -> "selected_search_float"
        is ScreenResultKey.SelectedSearchClear -> "selected_search_clear"
    }