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

fun <T : Parcelable> NavController.setScreenResult(key: ScreenResultKey, value: T, route: String? = null) {
    setScreenResultInternal(key, value, route)
}

fun <T : Number> NavController.setScreenResult(key: ScreenResultKey, value: T, route: String? = null) {
    setScreenResultInternal(key, value, route)
}

fun NavController.setScreenResult(key: ScreenResultKey, value: Boolean, route: String? = null) {
    setScreenResultInternal(key, value, route)
}

fun NavController.setScreenResult(key: ScreenResultKey, value: String, route: String? = null) {
    setScreenResultInternal(key, value, route)
}

fun <T : Parcelable> NavController.setScreenResultAndPopBack(key: ScreenResultKey, value: T, route: String? = null) {
    setScreenResultAndPopBackInternal(key, value, route)
}

fun <T : Number> NavController.setScreenResultAndPopBack(key: ScreenResultKey, value: T, route: String? = null) {
    setScreenResultAndPopBackInternal(key, value, route)
}

fun NavController.setScreenResultAndPopBack(key: ScreenResultKey, value: Boolean, route: String? = null) {
    setScreenResultAndPopBackInternal(key, value, route)
}

fun NavController.setScreenResultAndPopBack(key: ScreenResultKey, value: String, route: String? = null) {
    setScreenResultAndPopBackInternal(key, value, route)
}

private fun <T> NavController.setScreenResultAndPopBackInternal(key: ScreenResultKey, value: T, route: String? = null): Boolean {
    setScreenResultInternal(key, value, route)
    return if (route != null) {
        popBackStack(route, false)
    } else {
        popBackStack()
    }
}

private fun <T> NavController.setScreenResultInternal(key: ScreenResultKey, value: T, route: String? = null) {
    if (route != null) {
        getBackStackEntry(route).setScreenResultInternal(key, value)
    } else {
        previousBackStackEntry?.setScreenResultInternal(key, value)
    }
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

fun NavController.setUnitScreenResult(key: ScreenResultKey, route: String? = null) {
    setScreenResultInternal(key, ParcelableUnit, route)
}

fun NavController.setUnitScreenResultAndPopBack(key: ScreenResultKey, route: String? = null) {
    setScreenResultAndPopBack(key, ParcelableUnit, route)
}

@Parcelize
private object ParcelableUnit : Parcelable