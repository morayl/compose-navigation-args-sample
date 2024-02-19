package com.morayl.composenavigationargs.core.ui.ext

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.morayl.composenavigationargs.core.ui.constant.ScreenResultKey
import com.morayl.composenavigationargs.core.ui.constant.value
import kotlinx.parcelize.Parcelize

@SuppressLint("ComposableNaming")
@Composable
fun <T> NavBackStackEntry.consumeScreenResult(key: ScreenResultKey<T>, action: (T) -> Unit) {
    LaunchedEffect(Unit) {
        savedStateHandle.get<T>(key.value)
        val result = savedStateHandle.get<T>(key.value) ?: return@LaunchedEffect
        action(result)
        savedStateHandle.remove<T>(key.value)
    }
}

fun <T : Parcelable> NavController.setScreenResult(key: ScreenResultKey<T>, value: T, route: String? = null) {
    setScreenResultInternal(key, value, route)
}

fun <T : Number> NavController.setScreenResult(key: ScreenResultKey<T>, value: T, route: String? = null) {
    setScreenResultInternal(key, value, route)
}

fun NavController.setScreenResult(key: ScreenResultKey<Boolean>, value: Boolean, route: String? = null) {
    setScreenResultInternal(key, value, route)
}

fun NavController.setScreenResult(key: ScreenResultKey<String>, value: String, route: String? = null) {
    setScreenResultInternal(key, value, route)
}

fun <T : Parcelable> NavController.setScreenResultAndPopBack(key: ScreenResultKey<T>, value: T, route: String? = null) {
    setScreenResultAndPopBackInternal(key, value, route)
}

fun <T : Number> NavController.setScreenResultAndPopBack(key: ScreenResultKey<T>, value: T, route: String? = null) {
    setScreenResultAndPopBackInternal(key, value, route)
}

fun NavController.setScreenResultAndPopBack(key: ScreenResultKey<Boolean>, value: Boolean, route: String? = null) {
    setScreenResultAndPopBackInternal(key, value, route)
}

fun NavController.setScreenResultAndPopBack(key: ScreenResultKey<String>, value: String, route: String? = null) {
    setScreenResultAndPopBackInternal(key, value, route)
}

fun NavController.setScreenResultAndPopBack(key: ScreenResultKey<ParcelableUnit>, route: String? = null) {
    setScreenResultAndPopBackInternal(key, ParcelableUnit, route)
}

private fun <T> NavController.setScreenResultAndPopBackInternal(key: ScreenResultKey<T>, value: T, route: String? = null): Boolean {
    setScreenResultInternal(key, value, route)
    return if (route != null) {
        popBackStack(route, false)
    } else {
        popBackStack()
    }
}

private fun <T> NavController.setScreenResultInternal(key: ScreenResultKey<T>, value: T, route: String? = null) {
    if (route != null) {
        getBackStackEntry(route).setScreenResultInternal(key, value)
    } else {
        previousBackStackEntry?.setScreenResultInternal(key, value)
    }
}

private fun <T> NavBackStackEntry.setScreenResultInternal(key: ScreenResultKey<T>, value: T) {
    savedStateHandle[key.value] = value
}

@Parcelize
object ParcelableUnit : Parcelable