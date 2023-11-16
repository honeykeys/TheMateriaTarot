package com.honeykeys.materiatarot.presentation

import androidx.lifecycle.ViewModel
import com.honeykeys.materiatarot.data.ReadingRepository
import java.time.LocalDate


class LibraryViewModel (private val readingRepository: ReadingRepository): ViewModel() {

    private var libraryMap: Map<Long, LocalDate> = readingRepository.getReadingMap()
    fun startOldReading(selectedReading: Int) {
        /* navigate to the reading screen */
    }
    fun updateLibrary() {
        libraryMap = readingRepository.getReadingMap()
    }
}
