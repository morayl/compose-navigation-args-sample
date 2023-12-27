package com.morayl.composenavigationargs.feature.search

import androidx.lifecycle.ViewModel
import com.morayl.composenavigationargs.core.model.SearchParameter
import com.morayl.composenavigationargs.core.ui.ext.stateIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchTopViewModel @Inject constructor() : ViewModel() {
    private val _parameterFlow: MutableStateFlow<SearchParameter?> = MutableStateFlow(null)
    val parameterFlow: StateFlow<String> = _parameterFlow.map { it?.toString() ?: "no parameter" }.stateIn("")

    private val _floatValueFlow: MutableStateFlow<Float?> = MutableStateFlow(null)
    val floatValueFlow: StateFlow<String> = _floatValueFlow.map { it?.toString() ?: "no float" }.stateIn("")

    fun updateParameter(parameter: SearchParameter) {
        _parameterFlow.update { parameter }
    }

    fun updateFloat(value: Float) {
        _floatValueFlow.update { value }
    }

    fun clearResults() {
        _parameterFlow.update { null }
        _floatValueFlow.update { null }
    }

}