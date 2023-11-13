package com.honeykeys.materiatarot.data

import java.util.Date

data class TarotCard(
    val cardName: String,
    val cardNumber: Int,
    val cardImage: Int,
)

data class TarotReading(
    val readingName: String,
    val readingDate: Date,
    val readingValues: List<TarotCard>
)

