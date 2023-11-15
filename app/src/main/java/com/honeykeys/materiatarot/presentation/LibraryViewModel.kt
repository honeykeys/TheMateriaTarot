package com.honeykeys.materiatarot.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val readingRepository: ReadingRepository
): ViewModel() {
    val libraryFlow: Flow<List<Int>> = readingRepository.getLibraryFlow()
        .asLiveData(viewModelScope.coroutineContext)
    private val selectedReading: MutableState<Int> = mutableStateOf(0)
    fun startOldReading(selectedReading: Int) {
        /* navigate to the reading screen and give it the current reading id */
    }
}