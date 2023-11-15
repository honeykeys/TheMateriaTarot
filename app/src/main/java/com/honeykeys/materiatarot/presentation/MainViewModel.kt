package com.honeykeys.materiatarot.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.honeykeys.materiatarot.R
import java.time.LocalDate
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: TarotReadingRepository
): ViewModel() {
    val dailyCard = repository.getRandomCard()
    val allCards = repository.getAllCards()
    private var currentReading = Reading(0, LocalDate.now(), emptyList())
    val currentCard: MutableState<Int> = mutableStateOf(R.drawable.cardback)
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
