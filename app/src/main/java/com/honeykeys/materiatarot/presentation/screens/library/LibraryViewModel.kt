package com.honeykeys.materiatarot.presentation.screens.library

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.honeykeys.materiatarot.domain.Library.LibraryUseCase
import com.honeykeys.materiatarot.domain.TarotReading.TarotReading
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LibraryViewModel(
    private val libraryUseCase: LibraryUseCase
) : ViewModel() {

    private val _savedReadingLabels = MutableStateFlow<List<Int>>(emptyList())
    val savedReadingLabels: StateFlow<List<Int>> = _savedReadingLabels

    private val _selectedReading = MutableLiveData<TarotReading?>()
    val selectedReading: LiveData<TarotReading?> = _selectedReading

    init {
        fetchSavedReadingLabels()
    }

    private fun fetchSavedReadingLabels() {
        viewModelScope.launch {
            libraryUseCase.getSavedReadingLabels().collect { labels ->
                _savedReadingLabels.value = labels
            }
        }
    }
    fun onReadingSelected(readingId: Int) {
        viewModelScope.launch {
            val savedReading = libraryUseCase.getSavedReading(readingId)
            _selectedReading.value = savedReading
        }
    }

    fun clearSelectedReadingId() {
        null.also { _selectedReading.value = it }
    }

}
