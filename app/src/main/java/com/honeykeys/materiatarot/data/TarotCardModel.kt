package com.honeykeys.materiatarot.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import java.util.Date

data class TarotCard(
    val cardName: Int,
    val cardNumber: Int,
    val cardImage: Int,
    val cardUpright: Int,
    val cardReversed: Int,
    var isReversed: Boolean = false,
    var isFlipped: MutableState<Boolean> = mutableStateOf(false)
)



