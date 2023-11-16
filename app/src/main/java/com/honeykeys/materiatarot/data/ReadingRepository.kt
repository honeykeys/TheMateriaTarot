package com.honeykeys.materiatarot.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt
import com.honeykeys.materiatarot.MateriaTarotApp


class ReadingRepository1 @Inject constructor(
    private val readingDao: ReadingDao,
) {
     fun saveNewReading(deck: List<Int>, position: Int, positionMap: Map<Int, Int>) {
         val reading = Reading()
    }
    fun startSavedReading(id: Long): Reading {
        return readingDao.getReadingById(id)
    }
    fun getAllReadingsFlow(): Flow<List<Long>> {
        return readingDao.getAllReadings()
            .flowOn(Dispatchers.IO)
    }

}