package com.honeykeys.materiatarot.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt
import com.honeykeys.materiatarot.MateriaTarotApp


class ReadingRepository @Inject constructor(
    private val readingDao: ReadingDao,
    private val appContext: MateriaTarotApp
) {

    init {
        var currentReading: Reading
        var currentCard: TarotCard
    }
    fun getAllCards(): List<TarotCard> {
        return fullCards
    }
    fun getRandomCard(): TarotCard {
        val randomCard = Random.nextInt(1..78)
        return fullCards[randomCard]
    }
    fun startNewReading(): {
        val deck = fullCards.shuffled()
        generateRandomReversed(deck)
        flipAllCards(deck)
        return deck
    }



     fun saveNewReading(reading: Reading) {
        val flippedCardsOnlyDeck = reading.readingDeck.filter{it.isFlipped.value}
        readingDao.insertReading(Reading(0, reading.readingDate, flippedCardsOnlyDeck))
    }
    fun startSavedReading(id: Long): Reading {
        return readingDao.getReadingById(id)
    }
    fun getAllReadingsFlow(): Flow<List<Long>> {
        return readingDao.getAllReadings()
            .flowOn(Dispatchers.IO)
    }
    private fun generateRandomReversed(deck: List<TarotCard>) {
        for (card in deck) {
            card.isReversed = Random.nextBoolean()
        }
    }
    fun flipCard(card: TarotCard) {
        if (card.isFlipped.value) {
            return
        }
        card.isFlipped.value = true
    }
    private fun flipAllCards(deck: List<TarotCard>) {
        for (card in deck) {
            card.isFlipped.value = true
        }
    }
}