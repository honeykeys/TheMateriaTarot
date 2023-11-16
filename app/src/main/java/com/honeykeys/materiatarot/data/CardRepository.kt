package com.honeykeys.materiatarot.data

class CardRepository constructor() {
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