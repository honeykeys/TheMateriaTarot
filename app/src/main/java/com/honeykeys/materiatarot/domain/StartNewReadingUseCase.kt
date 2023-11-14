package com.honeykeys.materiatarot.domain

import com.honeykeys.materiatarot.data.TarotCard
import com.honeykeys.materiatarot.data.TarotReading
import com.honeykeys.materiatarot.data.fullCards
import kotlin.random.Random

class StartNewReadingUseCase() {
    val deck = fullCards.shuffled()
    init {
        randomiseCardReversal(deck)
        flipCardsDown(deck)
    }

    fun saveNewReading(){
        val savedDeck = deck.filter{it.isFlipped}
    }
    private fun randomiseCardReversal(deck: List<TarotCard>) {
        for (card in deck) {
            card.isReversed = Random.nextBoolean()
        }
    }
    private fun flipCardsDown (deck: List<TarotCard>) {
        for (card in deck) {
            card.isFlipped = true
        }
    }

}