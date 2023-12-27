package com.morayl.composenavigationargs.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import java.time.LocalTime

@Parcelize
@Serializable
data class SearchParameter(val word: String, val number: Int, val order: Order, val second: Float = LocalTime.now().second.toFloat()) :
    Parcelable
