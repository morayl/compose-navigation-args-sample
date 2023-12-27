package com.morayl.composenavigationargs.feature.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchTopViewModel @Inject constructor() : ViewModel() {
    val message = "hello world"
}