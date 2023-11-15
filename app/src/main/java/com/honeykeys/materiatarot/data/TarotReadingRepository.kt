package com.honeykeys.materiatarot.data

import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import java.time.LocalDate
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt
import android.content.Context
import androidx.compose.runtime.MutableState
import com.honeykeys.materiatarot.MateriaTarotApp
import com.honeykeys.materiatarot.domain.TarotReadingRepository
import dagger.hilt.android.scopes.ViewModelScoped


class TarotReadingRepositoryImpl @Inject constructor(
    private val readingDao: ReadingDao,
    private val appContext: MateriaTarotApp
): TarotReadingRepository {
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