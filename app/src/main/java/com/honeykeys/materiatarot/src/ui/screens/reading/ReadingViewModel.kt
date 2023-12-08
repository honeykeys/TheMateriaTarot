package com.honeykeys.materiatarot.src.ui.screens.reading

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.honeykeys.materiatarot.src.data.model.TarotCard
import com.honeykeys.materiatarot.src.domain.Library.LibraryUseCase
import com.honeykeys.materiatarot.src.domain.TarotReading.TarotReading
import com.honeykeys.materiatarot.src.domain.TarotReading.TarotReadingUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReadingViewModel constructor(
    private val tarotReadingUseCase: TarotReadingUseCase,
    private val libraryUseCase: LibraryUseCase
): ViewModel() {

    private val _activeReading = MutableLiveData<Boolean>(false)
    val activeReading: LiveData<Boolean> = _activeReading

    private val _showDetails = MutableLiveData<Boolean>(false)
    val showDetails: LiveData<Boolean> = _showDetails

    private val readingType = MutableLiveData<ReadingType>(ReadingType.NEW)

    private val _currentReading = MutableLiveData<TarotReading>()
    val currentReading: LiveData<TarotReading> = _currentReading

    /* prompt the reader if they press startNewReading*/
    private val _showDialog = MutableLiveData<Boolean>(false)
    val showDialog: LiveData<Boolean> = _showDialog

    fun triggerNewReadingDialog() {
        _activeReading.value = false
        _showDialog.value = true
    }

    fun onDialogSubmit(layout: String, question: String) {
        _showDialog.value = false
        _activeReading.value = true
        readingType.value = ReadingType.NEW
        _currentReading.value = tarotReadingUseCase.setTarotReading(layout,question)
    }

    fun onDialogDismiss() {
        _showDialog.value = false
    }

    fun getReadingCards(): List<TarotCard> {
        return currentReading.value!!.readingCards
    }

    fun getReadingType(): ReadingType {
        return readingType.value!!
    }

    fun triggerReadingSave() {
        if (readingType.value == ReadingType.NEW) {
            viewModelScope.launch {
                saveNewReading()
            }
        }
    }

    private suspend fun saveNewReading() {
        withContext(Dispatchers.IO) {
            currentReading.value?.let { tarotReadingUseCase.saveTarotReading(it) }
        }
    }

    fun triggerSavedReading(readingId: Int) {
        viewModelScope.launch {
            startSavedReading(libraryUseCase.getSavedReading(readingId))
        }
    }

    private suspend fun startSavedReading(reading: TarotReading) {
        _activeReading.value = true
        readingType.value = ReadingType.SAVED
        _currentReading.value = reading
    }

    fun toggleDetails() {
        _showDetails.value = _showDetails.value != true
    }

}