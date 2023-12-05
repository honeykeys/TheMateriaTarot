package com.honeykeys.materiatarot.di

import androidx.room.Room
import com.honeykeys.materiatarot.MateriaTarotApp
import com.honeykeys.materiatarot.data.datasource.local.ReadingDatabase
import com.honeykeys.materiatarot.data.repository.CardRepository
import com.honeykeys.materiatarot.data.repository.ReadingRepository
import com.honeykeys.materiatarot.presentation.screens.library.LibraryViewModel
import com.honeykeys.materiatarot.presentation.screens.reading.ReadingViewModel

class AppContainer {

    private val db = Room.databaseBuilder(
        MateriaTarotApp.getAppContext(),
        ReadingDatabase::class.java, "reading"
    ).build()

    private val readingDao = db.readingDao()
    private val readingRepository = ReadingRepository(readingDao)
    private val cardRepository = CardRepository()

    private val readingViewModelFactory = ReadingViewModelFactory(readingRepository, cardRepository)
    private val libraryViewModelFactory = LibraryViewModelFactory(readingRepository, cardRepository)


    val readingViewModel: ReadingViewModel = readingViewModelFactory.create()
    val libraryViewModel: LibraryViewModel = libraryViewModelFactory.create()

}
interface ViewModelFactory<T> {
    fun create(): T
}
class ReadingViewModelFactory(
    private val readingRepository: ReadingRepository,
    private val cardRepository: CardRepository
) : ViewModelFactory<ReadingViewModel> {
        override fun create(): ReadingViewModel {
            return ReadingViewModel(readingRepository, cardRepository)
        }
}

class LibraryViewModelFactory(
    private val readingRepository: ReadingRepository,
    private val cardRepository: CardRepository
): ViewModelFactory<LibraryViewModel> {
    override fun create(): LibraryViewModel {
        return LibraryViewModel(readingRepository, cardRepository)
    }
}
