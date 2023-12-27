package com.morayl.composenavigationargs.feature.search

import androidx.lifecycle.ViewModel
import com.morayl.composenavigationargs.core.model.SearchParameter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SearchTopViewModel @Inject constructor() : ViewModel() {
    private val _parameterFlow: MutableStateFlow<String> = MutableStateFlow("no parameter")
    val parameterFlow: StateFlow<String> = _parameterFlow.asStateFlow()

    private val _floatValueFlow: MutableStateFlow<String> = MutableStateFlow("no float")
    val floatValueFlow: StateFlow<String> = _floatValueFlow.asStateFlow()

    fun updateParameter(parameter: SearchParameter) {
        _parameterFlow.update { parameter.toString() }
    }

    fun updateFloat(value: Float) {
        _floatValueFlow.update { value.toString() }
    }

    fun clearResults() {
        _parameterFlow.update { "no parameter" }
        _floatValueFlow.update { "no float" }
    }

}