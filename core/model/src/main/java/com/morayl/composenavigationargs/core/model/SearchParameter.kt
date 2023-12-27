package com.morayl.composenavigationargs.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchParameter(val word: String, val number: Int, val order: Order) : Parcelable
