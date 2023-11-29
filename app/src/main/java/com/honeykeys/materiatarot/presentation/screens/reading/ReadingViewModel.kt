package com.honeykeys.materiatarot.presentation.screens.reading

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.honeykeys.materiatarot.R
import com.honeykeys.materiatarot.data.repository.CardRepository
import com.honeykeys.materiatarot.data.repository.ReadingRepository
import kotlin.random.Random

class ReadingViewModel constructor(
    private val readingRepository: ReadingRepository,
    private val cardRepository: CardRepository
): ViewModel() {
    /* home = homescreen, read = readingscreen, deck = deckscreen */
    private val type: MutableState<String> = mutableStateOf("home")
    private val deck: MutableState<List<Int>> = mutableStateOf(getDeck(false))
    private val card: MutableState<Int> = mutableStateOf(0)
    private val position: MutableState<Int> = mutableStateOf(0)
    private var positionMap = mutableMapOf<Int, Boolean>()
    val isReversed: MutableState<Boolean> = mutableStateOf(false)
    private val isFaceDown: MutableState<Boolean> = mutableStateOf(false)
    val cardArt: MutableState<Int> = mutableStateOf(getCardArt(card.value))

    private fun getCardArt(cardNumber: Int): Int {
        return cardRepository.getCardArt(cardNumber)
    }
    /* moves the pointer left in the List, checking if the pointer is at a position
    * greater than or equal to the size of the deck list */
    fun nextCard() {
        if (isFaceDown.value) { return }
        if (position.value >= deck.value.size) { return }

        position.value += 1

        if (type.value == "read") { randomizeCardReversed()}
        if (type.value == "read") { isFaceDown.value = true}

        card.value = deck.value[position.value]
    }
    /* moves the pointer right in the list, checking if the pointer is at the very
    rightmost index */
    fun lastCard() {
        if (position.value == 1) { return }

        position.value -= 1
        card.value = deck.value[position.value]
    }
    fun flipCardFaceUp() {
        isFaceDown.value = false
    }
    /* generates a random reversed position for the current card
    * then adds that position to a map */
    private fun randomizeCardReversed() {
        if (positionMap.containsKey(position.value)) { return }
        isReversed.value = Random.nextBoolean()
        positionMap[position.value]  =  isReversed.value
    }
    /* Sends the deck, the position the reading ended, and the map of isReversedValues
    * to the repository for saving */
    fun saveNewReading() {
        if (position.value < 2) { return }
        readingRepository.saveNewReading(deck.value, position.value, positionMap.toMap())
    }
    fun startNewReading() {
        type.value = "read"
        deck.value = getDeck(true)
        positionMap.clear()
        position.value = 0
        card.value = deck.value[position.value]
        cardArt.value = getCardArt(card.value)
    }
    fun startSavedReading(id: Int) {
        type.value = "saved"
        deck.value = readingRepository.getSavedReadingDeck(id)
        positionMap.clear()
        positionMap = readingRepository.getSavedReadingPositionMap(id).toMutableMap()
        position.value = 0
        card.value = deck.value[position.value]
        cardArt.value = getCardArt(card.value)
    }
    fun startDeckReview() {
        type.value = "deck"
        deck.value = getDeck(false)
        positionMap.clear()
        position.value = 0
        card.value = deck.value[position.value]
        cardArt.value = getCardArt(card.value)
    }
    fun getCardArt(): Int {
        if (isFaceDown.value) { return R.drawable.cardback}
        return cardRepository.getCardArt(card.value)
    }
    fun getCardName(): Int {
        if (isFaceDown.value) {return R.string.facedown}
        return cardRepository.getCardName(card.value)
    }
    fun getCardUpright(): Int {
        if (isFaceDown.value) {return R.string.facedown_two}
        return cardRepository.getCardUpright(card.value)
    }
    fun getCardReversed(): Int {
        if (isFaceDown.value) {return R.string.facedown_three}
        return cardRepository.getCardReversed(card.value)
    }
    fun getCardNumber(): Int {
        if (isFaceDown.value) {return 0}
        return card.value
    }
    private fun getDeck(shuffled: Boolean): List<Int> {
        if (shuffled) {return (1..78).toList().shuffled()}
        return (1..78).toList().shuffled()
    }

}