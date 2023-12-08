package com.honeykeys.materiatarot.domain.TarotReading

import com.honeykeys.materiatarot.data.model.ReadingLayout
import com.honeykeys.materiatarot.data.model.TarotCard
import java.time.LocalDate

data class TarotReading(
    val readingCards: List<TarotCard>,
    val layout: ReadingLayout,
    val question: String
)

data class SavedReadingLabel(
    val readingNumber: Number,
    val readingDate: LocalDate,
    val question: String
)
