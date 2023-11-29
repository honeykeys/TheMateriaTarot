package com.honeykeys.materiatarot.data.repository

import com.honeykeys.materiatarot.data.converters.IntegerListTypeConverter
import com.honeykeys.materiatarot.data.converters.IntegerMapTypeConverter
import com.honeykeys.materiatarot.data.datasource.local.Reading
import com.honeykeys.materiatarot.data.datasource.local.ReadingDao
import java.time.LocalDate


class ReadingRepository constructor(
    private val readingDao: ReadingDao,
) {

    private val integerConverter = IntegerListTypeConverter()
    private val mapConverter = IntegerMapTypeConverter()

     fun saveNewReading(deck: List<Int>, position: Int, positionMap: Map<Int, Boolean>) =
         readingDao.insertReading(
             Reading(0, LocalDate.now(),
                 integerConverter.fromListOfIntegersToString(deck), positionMap)
         )
    fun getSavedReadingDeck(id: Int): List<Int> =
        integerConverter.fromStringToListOfIntegers(readingDao.getReadingDeck(id))
    fun getSavedReadingPositionMap(id: Int): Map<Int, Boolean> =
        mapConverter.fromJson(readingDao.getPositionMap(id))
    fun getReadingMap(): Map<Int, String> {
        val readingNumbers = readingDao.getReadingIds()
        val readingDates = convertString(readingDao.getReadingDates())

        val stringDates = readingDates.map { it.toString() }
        return readingNumbers.zip(stringDates).toMap()
    }
    private fun convertString(stringList: List<String>): List<LocalDate> {
        return stringList.map { LocalDate.parse(it) }
    }

}
