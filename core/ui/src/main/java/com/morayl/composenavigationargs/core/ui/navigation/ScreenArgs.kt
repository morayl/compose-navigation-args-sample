package com.morayl.composenavigationargs.core.ui.navigation

import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface ScreenArgs : Parcelable {
    companion object {

        const val KEY = "key_screen_args"
    }
}

context(ViewModel)
fun <T> SavedStateHandle.getScreenArg(): T {
    return get<T>(ScreenArgs.KEY) as T
}
