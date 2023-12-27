package com.morayl.composenavigationargs.feature.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.morayl.composenavigationargs.core.ui.navigation.args.SearchResultArgs
import com.morayl.composenavigationargs.core.ui.navigation.getScreenArg
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    val screenArgs: SearchResultArgs = savedStateHandle.getScreenArg()
}