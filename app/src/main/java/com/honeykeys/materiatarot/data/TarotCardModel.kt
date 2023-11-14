package com.honeykeys.materiatarot.data

import java.util.Date

data class TarotCard(
    val cardName: Int,
    val cardNumber: Int,
    val cardImage: Int,
    val cardUpright: Int,
    val cardReversed: Int,
    var isReversed: Boolean = false,
    var isFlipped: Boolean = false
)



