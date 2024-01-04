package com.morayl.composenavigationargs.toplevel

import android.os.Bundle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.morayl.composenavigationargs.core.ui.navigation.ScreenArgs
import kotlinx.serialization.json.Json

internal inline fun <reified T : ScreenArgs> navScreenArgument(): List<NamedNavArgument> {
    return listOf(navArgument(ScreenArgs.KEY) {
        this.type = navType<T>(isNullableAllowed = false)
    })
}

internal inline fun <reified T : ScreenArgs> navScreenArgument(defaultValue: T): List<NamedNavArgument> {
    return listOf(navArgument(ScreenArgs.KEY) {
        this.type = navType<T>(isNullableAllowed = false)
        this.defaultValue = defaultValue
    })
}

private inline fun <reified T : ScreenArgs> navType(isNullableAllowed: Boolean = false): NavType<T> {
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