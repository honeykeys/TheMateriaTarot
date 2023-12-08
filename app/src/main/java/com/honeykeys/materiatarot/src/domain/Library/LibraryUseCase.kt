package com.honeykeys.materiatarot.src.domain.Library

import com.honeykeys.materiatarot.src.data.repository.ReadingRepository
import com.honeykeys.materiatarot.src.domain.TarotReading.TarotReading
import kotlinx.coroutines.flow.Flow

class LibraryUseCase(
    private val readingRepository: ReadingRepository
) {

    suspend fun getSavedReadingLabels(): Flow<List<Int>> {
        return readingRepository.getReadingIds()
    }

    suspend fun getSavedReading(readingId: Int): TarotReading {
        return readingRepository.getSavedReading(readingId)
    }

    suspend fun deleteReading(readingId: Int) = readingRepository.deleteReading(readingId)
}