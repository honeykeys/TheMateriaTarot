package com.honeykeys.materiatarot.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import java.time.LocalDate
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

class TarotReadingRepository @Inject constructor(
    private val readingDao: ReadingDao,
) {
    fun getAllCards(): List<TarotCard> {
        return fullCards
    }
    fun getRandomCard(): TarotCard {
        val randomCard = Random.nextInt(1..78)
        return fullCards[randomCard]
    }
    fun startNewReading(): Reading {
        val deck = fullCards.shuffled()
        generateRandomReversed(deck)
        flipAllCards(deck)

        return Reading(
            readingDate = LocalDate.now(),
            readingDeck = deck
        )
    }
    fun saveNewReading(reading: Reading) {
        val flippedCardsOnlyDeck = reading.readingDeck.filter{it.isFlipped}
        readingDao.insertReading(Reading(0, reading.readingDate, flippedCardsOnlyDeck))
    }
    fun getReading(id: Long): Reading {
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
    private fun flipAllCards(deck: List<TarotCard>) {
        for (card in deck) {
            card.isFlipped = true
        }
    }
}