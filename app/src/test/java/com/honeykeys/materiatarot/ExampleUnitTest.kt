package com.honeykeys.materiatarot

import com.honeykeys.materiatarot.data.datasource.local.ReadingDao
import com.honeykeys.materiatarot.data.TarotReadingRepository
import com.honeykeys.materiatarot.data.datasource.local.fullCards
import org.mockito.Mockito.*
import org.mockito.ArgumentMatchers.*

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class DataLayerUnitTest() {

    @Mock
    lateinit var mockTarotDao: ReadingDao

    lateinit var tarotReadingRepository: TarotReadingRepository

    @Before
    fun setup() {
        tarotReadingRepository = TarotReadingRepository(mockTarotDao)
    }
    @Test
    fun getAllCards_isCorrect() {
        assert(tarotReadingRepository.getAllCards() == fullCards)
    }

    @Test
    fun getRandomCards_isCorrect() {
        assertNotNull(tarotReadingRepository.getRandomCard())
    }



}