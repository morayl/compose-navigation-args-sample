package com.morayl.composenavigationargs.feature.search

import androidx.lifecycle.ViewModel
import com.morayl.composenavigationargs.core.model.Order
import com.morayl.composenavigationargs.core.model.SearchParameter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchParameterViewModel @Inject constructor() : ViewModel() {
    val parameter = SearchParameter("word", 1, Order.ASC)
}