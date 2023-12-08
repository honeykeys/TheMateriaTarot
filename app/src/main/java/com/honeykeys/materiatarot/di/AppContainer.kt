package com.honeykeys.materiatarot.di

import androidx.room.Room
import com.honeykeys.materiatarot.MateriaTarotApp
import com.honeykeys.materiatarot.data.datasource.local.ReadingDatabase
import com.honeykeys.materiatarot.data.repository.CardRepository
import com.honeykeys.materiatarot.data.repository.ReadingRepository
import com.honeykeys.materiatarot.domain.Library.LibraryUseCase
import com.honeykeys.materiatarot.domain.TarotReading.TarotReadingUseCase
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
    private val libraryUseCase = LibraryUseCase(readingRepository)
    private val tarotReadingUseCase = TarotReadingUseCase(readingRepository, cardRepository)


    private val readingViewModelFactory = ReadingViewModelFactory(tarotReadingUseCase, libraryUseCase)
    private val libraryViewModelFactory = LibraryViewModelFactory(libraryUseCase)


    val readingViewModel: ReadingViewModel = readingViewModelFactory.create()
    val libraryViewModel: LibraryViewModel = libraryViewModelFactory.create()

}
interface ViewModelFactory<T> {
    fun create(): T
}
class ReadingViewModelFactory(
    private val readingUseCase: TarotReadingUseCase,
    private val libraryUseCase: LibraryUseCase
) : ViewModelFactory<ReadingViewModel> {
        override fun create(): ReadingViewModel {
            return ReadingViewModel(readingUseCase, libraryUseCase)
        }
}

class LibraryViewModelFactory(
    private val libraryUseCase: LibraryUseCase
): ViewModelFactory<LibraryViewModel> {
    override fun create(): LibraryViewModel {
        return LibraryViewModel(libraryUseCase)
    }
}
