package com.honeykeys.materiatarot

import androidx.room.Room
import com.honeykeys.materiatarot.data.CardRepository
import com.honeykeys.materiatarot.data.ReadingDatabase
import com.honeykeys.materiatarot.data.ReadingRepository
import com.honeykeys.materiatarot.presentation.ReadingViewModel

class AppContainer {

    private val db = Room.databaseBuilder(
        MateriaTarotApp.getAppContext(),
        ReadingDatabase::class.java, "reading"
    ).build()

    private val readingDao = db.readingDao()
    val readingRepository = ReadingRepository(readingDao)
    val cardRepository = CardRepository()
    val readingViewModelFactory = ReadingViewModelFactory(readingRepository, cardRepository)
}
interface ViewModelFactory {
    fun create(): ReadingViewModel
}
class ReadingViewModelFactory(
    private val readingRepository: ReadingRepository,
    private val cardRepository: CardRepository) : ViewModelFactory {
        override fun create(): ReadingViewModel {
            return ReadingViewModel(readingRepository, cardRepository)
        }

    }
