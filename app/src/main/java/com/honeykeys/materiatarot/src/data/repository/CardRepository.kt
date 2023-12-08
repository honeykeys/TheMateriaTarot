package com.honeykeys.materiatarot.src.data.repository

import com.honeykeys.materiatarot.src.data.datasource.local.fullCards
import com.honeykeys.materiatarot.src.data.model.TarotCard
import kotlin.random.Random

class CardRepository() {
    fun getTarotCard(cardNumber: Int): TarotCard {
        val tarotCard = fullCards[cardNumber]
        tarotCard.isReversed = Random.nextBoolean()
        return tarotCard
    }
    fun getCardArt (cardNumber: Int): Int {
        val myCard = fullCards[cardNumber]
        return myCard.cardImage
    }
    fun getCardName(cardNumber: Int): Int{
        val myCard = fullCards[cardNumber]
        return myCard.cardName
    }
    fun getCardUpright(cardNumber: Int): Int{
        val myCard = fullCards[cardNumber]
        return myCard.cardUpright
    }
    fun getCardReversed(cardNumber: Int): Int{
        val myCard = fullCards[cardNumber]
        return myCard.cardReversed
    }

}