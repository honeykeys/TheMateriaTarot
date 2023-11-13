package com.honeykeys.materiatarot.util

import com.honeykeys.materiatarot.data.TarotCard

fun shuffleDeck(deck: List<TarotCard>): List<TarotCard> {
    return deck.shuffled()
}