package com.honeykeys.materiatarot.presentation.screens.library

import androidx.lifecycle.ViewModel
import com.honeykeys.materiatarot.data.repository.CardRepository
import com.honeykeys.materiatarot.data.repository.ReadingRepository


class LibraryViewModel (
    private val readingRepository: ReadingRepository,
    private val cardRepository: CardRepository): ViewModel() {

    private val _libraryMap: Map<Int, String> = readingRepository.getReadingMap()
    val libraryMap = _libraryMap

    fun getCardNames(): List<Int> {

        val deckValues = libraryMap.keys
        val cardNames: MutableList<Int> = mutableListOf()

        for (card in deckValues) {
            cardNames.add(cardRepository.getCardName(card))
        }

        return cardNames

    }
    fun getLibrary(): Map<Int, String> = _libraryMap
}
