package com.honeykeys.materiatarot.presentation.screens.library

import androidx.lifecycle.ViewModel
import com.honeykeys.materiatarot.data.repository.ReadingRepository


class LibraryViewModel (private val readingRepository: ReadingRepository): ViewModel() {

    private var _libraryMap: Map<Int, String> = readingRepository.getReadingMap()
    fun startOldReading(selectedReading: Int) {
        /* navigate to the reading screen */
    }
    fun getLibrary(): Map<Int, String> = _libraryMap

    fun updateLibrary() {
        _libraryMap = readingRepository.getReadingMap()
    }
}
