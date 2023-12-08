package com.honeykeys.materiatarot.src.data.model

data class TarotCard(
    val cardName: Int,
    val cardNumber: Int,
    val cardImage: Int,
    val cardUpright: Int,
    val cardReversed: Int,
    var isReversed: Boolean = false,
)

data class ReadingLayout(
    val numberOfCards: Int,
    val description: String,
    val positionMeaning: List<String>
)