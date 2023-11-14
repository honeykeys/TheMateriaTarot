package com.honeykeys.materiatarot.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.honeykeys.materiatarot.data.TarotCard
import com.honeykeys.materiatarot.data.TarotReadingRepository
import com.honeykeys.materiatarot.data.fullCards
import kotlin.random.Random


class MainViewModel(): ViewModel() {
    private val _isCardFlipped = mutableStateOf(true)
    val isCardFlipped: State<Boolean> = _isCardFlipped
    val deck = fullCards
    fun flipCard() {
        _isCardFlipped.value = !_isCardFlipped.value
    }

    fun startNewReading() {
    }
}
