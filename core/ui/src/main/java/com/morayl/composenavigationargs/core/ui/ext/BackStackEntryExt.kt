package com.morayl.composenavigationargs.core.ui.ext

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavBackStackEntry
import com.morayl.composenavigationargs.core.ui.constant.ScreenResultKey

@SuppressLint("ComposableNaming")
@Composable
fun <T> NavBackStackEntry.consumeScreenResult(key: ScreenResultKey, action: (T) -> Unit) {
    LaunchedEffect(Unit) {
        savedStateHandle.get<T>(key.value)
        val result = savedStateHandle.get<T>(key.value) ?: return@LaunchedEffect
        action(result)
        savedStateHandle.remove<T>(key.value)
    }
}

fun <T: Parcelable> NavBackStackEntry.setScreenResult(key: ScreenResultKey, value: T) {
    setScreenResultInternal(key, value)
}

fun <T: Number> NavBackStackEntry.setScreenResult(key: ScreenResultKey, value: T) {
    setScreenResultInternal(key, value)
}

fun NavBackStackEntry.setScreenResult(key: ScreenResultKey, value: Boolean) {
    setScreenResultInternal(key, value)
}

fun NavBackStackEntry.setScreenResult(key: ScreenResultKey, value: String) {
    setScreenResultInternal(key, value)
}

private fun <T> NavBackStackEntry.setScreenResultInternal(key: ScreenResultKey, value: T) {
    savedStateHandle[key.value] = value
}
