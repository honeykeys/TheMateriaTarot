package com.honeykeys.materiatarot.src.ui.screens.library

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.honeykeys.materiatarot.src.domain.Library.LibraryUseCase
import com.honeykeys.materiatarot.src.domain.TarotReading.TarotReading
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

    private val _showDialog = MutableLiveData<Boolean>(false)
    val showDialog: LiveData<Boolean> = _showDialog

    private val _selectedDeletion = MutableLiveData<Int>()
    val selectedDeletion = _selectedDeletion

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

    fun triggerDialog(id: Int) {
        _showDialog.value = true
        _selectedDeletion.value = id
    }

    fun triggerSubmit() {
        viewModelScope.launch { _selectedDeletion.value?.let { onDialogSubmit(it) } }
    }

    fun onDialogDismiss() {
        _showDialog.value = false
    }

    private suspend fun onDialogSubmit(id: Int) {
        _showDialog.value = false
        libraryUseCase.deleteReading(id)
    }

}
