package com.honeykeys.materiatarot.data

import java.time.LocalDate


class ReadingRepository constructor(
    private val readingDao: ReadingDao,
) {
     fun saveNewReading(deck: List<Int>, position: Int, positionMap: Map<Int, Boolean>) =
         readingDao.insertReading(Reading(0, LocalDate.now(), deck, positionMap))
    fun getSavedReadingDeck(id: Long): List<Int> = readingDao.getReadingDeck(id)
    fun getSavedReadingPositionMap(id: Long): Map<Int, Boolean> = readingDao.getPositionMap(id)
    fun getReadingMap(): Map<Long, LocalDate> =
            readingDao.getReadingIds().zip(readingDao.getReadingDates()).toMap()

}
