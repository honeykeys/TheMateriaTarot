package com.honeykeys.materiatarot.data.repository

import com.honeykeys.materiatarot.data.datasource.local.ReadingDao
import com.honeykeys.materiatarot.data.datasource.local.SavedReading
import com.honeykeys.materiatarot.data.model.ReadingLayout
import com.honeykeys.materiatarot.domain.TarotReading.TarotReading
import com.honeykeys.materiatarot.util.layoutToString
import com.honeykeys.materiatarot.util.stringToLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext


class ReadingRepository constructor(
    private val readingDao: ReadingDao
) {
     suspend fun saveNewReading(reading: TarotReading) =
         withContext(Dispatchers.IO) {
             readingDao.insertReading(
                 SavedReading(
                     readingDeck = reading.readingCards,
                     readingLayout = getLayoutName(reading.layout),
                     readingQuestion = reading.question
                 )
             )
         }

    suspend fun getReadingIds(): Flow<List<Int>> {
        return readingDao.getReadingIds()
    }

    suspend fun getSavedReading(id: Int): TarotReading {

        val reading = readingDao.getReading(id)

        return TarotReading(
            reading.readingDeck,
            stringToLayout(reading.readingLayout),
            reading.readingQuestion
        )
    }

    fun getLayout(layout: String): ReadingLayout {
        return stringToLayout(layout)
    }

    fun getLayoutName(layout: ReadingLayout): String {
        return layoutToString(layout)
    }

}
