package com.morayl.composenavigationargs.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalTime

@Parcelize
data class SearchParameter(val word: String, val number: Int, val order: Order, val time: LocalTime = LocalTime.now()) : Parcelable
