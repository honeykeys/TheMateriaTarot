package com.honeykeys.materiatarot.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.honeykeys.materiatarot.R
import com.honeykeys.materiatarot.data.Reading
import com.honeykeys.materiatarot.data.TarotCard
import com.honeykeys.materiatarot.data.TarotReadingRepository
import com.honeykeys.materiatarot.data.fullCards
import java.time.LocalDate
import javax.inject.Inject
import kotlin.random.Random


class MainViewModel @Inject constructor(private val repository: TarotReadingRepository): ViewModel() {

    val dailyCard = repository.getRandomCard()
    val allCards = repository.getAllCards()
    var currentReading = Reading(0, LocalDate.now(), emptyList())

    fun startNewReading() {
        currentReading = repository.startNewReading()
    }
    fun saveNewReading(reading: Reading) {
        repository.saveNewReading(reading)
    }
    fun startSavedReading(readingId: Long) {
        currentReading = repository.startSavedReading(readingId)
    }
    fun flipCard(card: TarotCard) {
        repository.flipCard(card)
    }
}
