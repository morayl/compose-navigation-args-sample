package com.morayl.composenavigationargs.core.ui.navigation.args

import com.morayl.composenavigationargs.core.model.SearchParameter
import com.morayl.composenavigationargs.core.ui.navigation.ScreenArgs
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class SearchResultArgs(val parameter: SearchParameter?, val float: Float) : ScreenArgs
