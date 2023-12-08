package com.honeykeys.materiatarot.domain.Library

import com.honeykeys.materiatarot.data.repository.ReadingRepository
import com.honeykeys.materiatarot.domain.TarotReading.TarotReading
import kotlinx.coroutines.flow.Flow

class LibraryUseCase(
    private val readingRepository: ReadingRepository) {

    suspend fun getSavedReadingLabels(): Flow<List<Int>> {
        return readingRepository.getReadingIds()
    }

    suspend fun getSavedReading(readingId: Int): TarotReading {
        return readingRepository.getSavedReading(readingId)
    }

}