package com.morayl.composenavigationargs.core.ui.ext

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.morayl.composenavigationargs.core.ui.constant.ScreenResultKey
import kotlinx.parcelize.Parcelize

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

fun <T : Parcelable> NavController.setScreenResultAndPopBack(key: ScreenResultKey, value: T) {
    setScreenResultAndPopBackInternal(key, value)
}

fun <T : Number> NavController.setScreenResultAndPopBack(key: ScreenResultKey, value: T) {
    setScreenResultAndPopBackInternal(key, value)
}

fun NavController.setScreenResultAndPopBack(key: ScreenResultKey, value: Boolean) {
    setScreenResultAndPopBackInternal(key, value)
}

fun NavController.setScreenResultAndPopBack(key: ScreenResultKey, value: String) {
    setScreenResultAndPopBackInternal(key, value)
}

private fun <T> NavController.setScreenResultAndPopBackInternal(key: ScreenResultKey, value: T): Boolean {
    previousBackStackEntry?.setScreenResultInternal(key, value)
    return popBackStack()
}

private fun <T> NavBackStackEntry.setScreenResultInternal(key: ScreenResultKey, value: T) {
    savedStateHandle[key.value] = value
}

@SuppressLint("ComposableNaming")
@Composable
fun NavBackStackEntry.consumeUnitScreenResult(key: ScreenResultKey, action: () -> Unit) {
    consumeScreenResult<ParcelableUnit>(key) {
        action()
    }
}

fun NavController.setUnitScreenResultAndPopBack(key: ScreenResultKey) {
    setScreenResultAndPopBack(key, ParcelableUnit)
}

@Parcelize
private object ParcelableUnit : Parcelable