package com.morayl.composenavigationargs.core.ui.navigation

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

interface ScreenArgs : Parcelable {
    companion object {

        const val SCREEN_ARG = "screen_arg"
    }
}

inline fun <reified T : ScreenArgs> T.toNavigationUri(): String {
    return Uri.encode(Json.encodeToString(this))
}

context(ViewModel)
fun <T> SavedStateHandle.getScreenArg(): T {
    return get<T>(ScreenArgs.SCREEN_ARG) as T
}

inline fun <reified T : Parcelable> navType(isNullableAllowed: Boolean = false): NavType<T> {
    return object : NavType<T>(isNullableAllowed = isNullableAllowed) {
        override fun put(bundle: Bundle, key: String, value: T) {
            bundle.putParcelable(key, value)
        }

        override fun get(bundle: Bundle, key: String): T? {
            return bundle.getParcelable(key) as? T
        }

        override fun parseValue(value: String): T {
            return Json.decodeFromString<T>(value)
        }
    }
}