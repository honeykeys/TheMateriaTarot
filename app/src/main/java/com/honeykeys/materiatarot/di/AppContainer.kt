package com.honeykeys.materiatarot.di

import androidx.room.Room
import com.honeykeys.materiatarot.MateriaTarotApp
import com.honeykeys.materiatarot.data.datasource.local.ReadingDatabase
import com.honeykeys.materiatarot.data.repository.CardRepository
import com.honeykeys.materiatarot.data.repository.ReadingRepository
import com.honeykeys.materiatarot.presentation.screens.reading.ReadingViewModel

class AppContainer {

    private val db = Room.databaseBuilder(
        MateriaTarotApp.getAppContext(),
        ReadingDatabase::class.java, "reading"
    ).build()

    private val readingDao = db.readingDao()
    private val readingRepository = ReadingRepository(readingDao)
    private val cardRepository = CardRepository()
    val readingViewModel = ReadingViewModelFactory(readingRepository, cardRepository)
}
interface ViewModelFactory {
    fun create(): ReadingViewModel
}
class ReadingViewModelFactory(
    private val readingRepository: ReadingRepository,
    private val cardRepository: CardRepository
) : ViewModelFactory {
        override fun create(): ReadingViewModel {
            return ReadingViewModel(readingRepository, cardRepository)
        }
    }
