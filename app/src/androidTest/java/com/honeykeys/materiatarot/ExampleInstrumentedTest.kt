package com.honeykeys.materiatarot

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.honeykeys.materiatarot.data.TarotCard
import com.honeykeys.materiatarot.domain.StartNewReadingUseCase

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UnitTest{
    @Test
    fun testStartNewReadingUseCase() {
        val testReading1 = StartNewReadingUseCase()
        val testReading2 = StartNewReadingUseCase()

        println("Testing first deck")
        printDeck(testReading1.deck)
        printDeck(testReading2.deck)
    }

    fun printDeck(deck: List<TarotCard>) {
        for (card in deck) {
            println(card)
        }
    }
}