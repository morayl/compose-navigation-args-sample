package com.morayl.composenavigationargs.ext

import android.net.Uri
import com.morayl.composenavigationargs.core.ui.navigation.ScreenArgs
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


inline fun <reified T : ScreenArgs> T.toNavigationUri(): String {
    return Uri.encode(Json.encodeToString(this))
}
