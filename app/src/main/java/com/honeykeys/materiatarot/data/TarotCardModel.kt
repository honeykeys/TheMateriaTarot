package com.honeykeys.materiatarot.data

import java.util.Date

data class TarotCard(
    val cardName: Int,
    val cardNumber: Int,
    val cardImage: Int,
    val cardUpright: Int,
    val cardReversed: Int
)

data class TarotReading(
    val readingName: String,
    val readingDate: Date,
    val readingValues: List<TarotCard>
)

