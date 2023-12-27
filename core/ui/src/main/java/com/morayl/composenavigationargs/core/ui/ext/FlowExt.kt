package com.morayl.composenavigationargs.core.ui.ext

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

private const val STOP_TIMEOUT_MILLS = 5_000L

context(ViewModel)
fun <T> Flow<T>.stateIn(
    initialValue: T,
    started: SharingStarted = SharingStarted.WhileSubscribed(stopTimeoutMillis = STOP_TIMEOUT_MILLS),
    scope: CoroutineScope = viewModelScope
): StateFlow<T> {
    return stateIn(scope, started, initialValue)
}
