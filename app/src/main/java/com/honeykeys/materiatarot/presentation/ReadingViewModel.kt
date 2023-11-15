package com.honeykeys.materiatarot.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ReadingViewModel @Inject constructor(
    private val readingRepository: ReadingRepository,
    private val cardRepository: CardRepository
) {
        private val deck: MutableState<List<Int>> = mutableStateOf(readingRepository.getUnshuffledDeck())
        private val card: MutableState<Int> = mutableStateOf(cardRepository.getDefaultCard())
        private val position: MutableState<Int> = mutableStateOf(0)
        val positionMap = mutableMapOf<Int, Boolean>()
        val cardArt: MutableState<Int> = mutableStateOf(cardRepository.getDefaultCard())
        val isReversed: MutableState<Boolean> = mutableStateOf(false)
        val isFaceDown: MutableState<Boolean> = mutableStateOf(false)
    private fun getCardArt(cardNumber: Int): Int {
        return cardRepository.getCardArt(cardNumber)
    }
    /* moves the pointer left in the List, checking if the pointer is at a position
    * greater than or equal to the size of the deck list */
    fun nextCard() {
        if (isFaceDown.value) { return }
        if (position.value >= deck.value.size) { return }

        position.value += 1
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
    fun randomizeCardReversed() {
        if (positionMap.containsKey(position.value)) { return }
        isReversed.value = Random.nextBoolean()
        positionMap[position.value]  =  isReversed.value
    }
    /* Sends the deck, the position the reading ended, and the map of isReversedValues
    * to the repository for saving */
    suspend fun saveNewReading() {
        if (position.value < 2) { return }
        readingRepository.saveReading(deck, position, positionMap)
    }
    fun startNewReading() {
        deck.value = readingRepository.getShuffledDeck()
        position.value = 0
        card.value = deck.value[position.value]
        cardArt.value = getCardArt(card.value)
    }
    fun startSavedReading() {
        deck.value = readingRepository.getSavedDeck()
        position.value = 0
        card.value = deck.value[position.value]
        cardArt.value = getCardArt(card.value)
    }
    fun startDeckReview() {
        deck.value = readingRepository.getUnshuffledDeck()
        position.value = 0
        card.value = deck.value[position.value]
        cardArt.value = getCardArt(card.value)
    }
}